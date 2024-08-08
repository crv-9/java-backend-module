package io.everyonecodes.w1springbeans.thethievesden.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// this is with deprecated code

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}


