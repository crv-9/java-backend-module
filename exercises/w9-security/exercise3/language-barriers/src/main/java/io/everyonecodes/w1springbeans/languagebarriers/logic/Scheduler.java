package io.everyonecodes.w1springbeans.languagebarriers.logic;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableScheduling
public class Scheduler {

    private final InteractionsService interactionsService;
    private final int amount = 100;

    public Scheduler(InteractionsService interactionsService) {
        this.interactionsService = interactionsService;

    }

    @Scheduled(fixedDelay = 5000)
    public void addInteractionsBySchedule() {
        interactionsService.incrementInteractionsCountByMany(amount);
    }


}
