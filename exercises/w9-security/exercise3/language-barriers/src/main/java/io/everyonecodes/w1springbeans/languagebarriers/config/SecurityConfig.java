package io.everyonecodes.w1springbeans.languagebarriers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        // this one lets the system know which are allowed without authentication
                        .requestMatchers(GET, "/").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails userGerman = User.withUsername("michael")
                .password(encoder.encode("geheim"))
                // here i am letting it know which it methods it can reach with this role
                .authorities("ROLE_USER", "ROLE_LANGUAGE_GERMAN")
                .build();
        UserDetails userEnglish = User.withUsername("stacey")
                .password(encoder.encode("secret"))
                // here i am letting it know which it methods it can reach with this role
                .authorities("ROLE_USER", "ROLE_LANGUAGE_ENGLISH")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .authorities("ROLE_ADMIN")
                .build();
        List<UserDetails> users = List.of(userGerman, userEnglish, admin);
        return new InMemoryUserDetailsManager(users);
    }
}

