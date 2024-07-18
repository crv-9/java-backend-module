package io.everyonecodes.w1springbeans.punchcards.config;

import io.everyonecodes.w1springbeans.punchcards.logic.PunchCardService;
import io.everyonecodes.w1springbeans.punchcards.model.PunchCard;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PunchCardRunner {

    @Bean
    ApplicationRunner runPuncher(PunchCardService punchCardService) {
        return args -> {
            PunchCard firstCard = new PunchCard();
            punchCardService.mySave(firstCard);

            List<PunchCard> previousLogs = punchCardService.findAll();

            System.out.println("Punched card saved: " + firstCard);

            System.out.println("Previous logs:");
            for (PunchCard previousLog : previousLogs) {
                System.out.println(previousLog);
            }
        };
    }

}
