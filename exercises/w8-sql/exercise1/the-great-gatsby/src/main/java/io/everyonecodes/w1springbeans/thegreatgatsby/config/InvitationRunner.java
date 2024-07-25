package io.everyonecodes.w1springbeans.thegreatgatsby.config;

import io.everyonecodes.w1springbeans.thegreatgatsby.logic.PartyService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InvitationRunner {
    @Bean
    ApplicationRunner runInvitatoin(PartyService partyService) {
        return args -> {

            partyService.invitationManager();

        };
    }

}
