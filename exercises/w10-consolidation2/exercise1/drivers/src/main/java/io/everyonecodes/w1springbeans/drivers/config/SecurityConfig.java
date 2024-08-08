package io.everyonecodes.w1springbeans.drivers.config;

import io.everyonecodes.w1springbeans.drivers.model.DriverPrincipal;
import io.everyonecodes.w1springbeans.drivers.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

// same three annotations for setting up access to our webapp
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    // reading from yaml file
    @Value("${adminuser.username}")
    private String username;

    @Value("${adminuser.password}")
    private String password;

    @Value("${adminuser.role}")
    private String role;




    // this bean you need to adapt the endpoint you want to allow to everyone
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, DriverRepository driverRepository) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        // this one lets the system know which are allowed without authentication
                        .requestMatchers(POST, "/drivers").permitAll()
//                        .requestMatchers(GET, "/drivers/all").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        // [EXTRA]
        // added for parallel in-memory authentication and database authentication
        http.authenticationProvider(inMemoryAuthenticationProvider());
        http.authenticationProvider(databaseAuthenticationProvider(userDetailsService(driverRepository)));

        return http.build();
    }

    //Loading users from Database
    //same three beans needed to:
    //PasswordEncoder -> to encrypt the passwords before we save them in the database
    //UserDetailsService -> to explain with our code how to load the users from the database (so this is no longer used for the in-memory users as we did until now)
    //DaoAuthenticationProvider -> to activate user management including the previous two (Dao - data access object)

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // this bean you need to adapt the repository where you are saving users
    // also adapt the MemberPrincipal method
    @Bean
    UserDetailsService userDetailsService(DriverRepository driverRepository) {
        return username -> driverRepository.findOneByUsername(username)
                .map(DriverPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }


    @Bean
    DaoAuthenticationProvider databaseAuthenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // [EXTRA] to allow in-memory authentication as well
    //

    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        UserDetails admin = User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .authorities(role)
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public DaoAuthenticationProvider inMemoryAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(inMemoryUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }



}
