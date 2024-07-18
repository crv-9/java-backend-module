package io.everyonecodes.w1springbeans.thefinalcountdown;

import io.everyonecodes.w1springbeans.thefinalcountdown.logic.CountdownManager;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheFinalCountdownManager {

    @Bean
    ApplicationRunner runCountdown(CountdownManager countdownManager){
        return args -> {
            countdownManager.getCountdowns();
        };
    }

}
