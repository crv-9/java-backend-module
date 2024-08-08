package io.everyonecodes.w1springbeans.mysterioussecretorder.config;

import io.everyonecodes.w1springbeans.mysterioussecretorder.model.Member;
import io.everyonecodes.w1springbeans.mysterioussecretorder.model.MemberPrincipal;
import io.everyonecodes.w1springbeans.mysterioussecretorder.repositories.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.nio.file.attribute.UserPrincipal;

import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    // this bean you need to adapt the endpoint you want to allow to everyone
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        // this one lets the system know which are allowed without authentication
                        // in this case no one, i commented it out
                        //.requestMatchers(GET, "/products").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // this bean doesn't change, only copy/paste


    // this bean doesn't change, only copy/paste
    @Bean
    DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // this bean you need to adapt the repository where you are saving users
    // also adapt the MemberPrincipal method
    @Bean
    UserDetailsService userDetailsService(MemberRepository memberRepository) {
        return username -> memberRepository.findOneByUsername(username)
                .map(MemberPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }






}
