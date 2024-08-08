package io.everyonecodes.w1springbeans.rides.config;

import io.everyonecodes.w1springbeans.rides.repos.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Value("${users.admin.username}")
    private String adminUser;
    @Value("${users.admin.password}")
    private String adminPass;
    @Value("${users.admin.authorities}")
    private String adminRole;

    @Value("${users.app.username}")
    private String appUser;
    @Value("${users.app.password}")
    private String appPass;
    @Value("${users.app.authorities}")
    private String appRole;

    // this bean you need to adapt the endpoint you want to allow to everyone
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, DriverRepository driverRepository) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                                // this one lets the system know which are allowed without authentication
                                //.requestMatchers(POST, "/drivers").permitAll()
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
        UserDetails admin = User.withUsername(adminUser)
                .password(encoder.encode(adminPass))
                // here i am letting it know which it methods it can reach with this role
                .authorities(adminRole)
                .build();
        UserDetails app = User.withUsername(appUser)
                .password(encoder.encode(appPass))
                // here i am letting it know which it methods it can reach with this role
                .authorities(appRole)
                .build();
        List<UserDetails> users = List.of(admin, app);
        return new InMemoryUserDetailsManager(users);
    }

}
