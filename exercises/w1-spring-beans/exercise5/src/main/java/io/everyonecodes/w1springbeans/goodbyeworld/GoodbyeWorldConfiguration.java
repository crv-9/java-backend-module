package io.everyonecodes.w1springbeans.goodbyeworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoodbyeWorldConfiguration {

    @Bean
    GoodbyeWorld goodbyeWorld() {
        return new GoodbyeWorld();
    }
}
