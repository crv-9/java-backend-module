package io.everyonecodes.w1springbeans.thefinalcountdown.logic;

import io.everyonecodes.w1springbeans.thefinalcountdown.model.Countdown;
import io.everyonecodes.w1springbeans.thefinalcountdown.model.CountdownRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountdownManager {

    CountdownRepository countdownRepository;
    AccumulationManager accumulationManager;


    public CountdownManager(CountdownRepository countdownRepository, AccumulationManager accumulationManager) {
        this.countdownRepository = countdownRepository;
        this.accumulationManager = accumulationManager;
    }

    public void getCountdowns(){
        // If no countdown found, then i create a new one
        if(countdownRepository.count() == 0){
            countdownRepository.save(createCountdown());
            System.out.println("Countdown at: " + countdownRepository.findAll().get(0).getCount());
        }
        // when there is a countdown
        else {
            List<Countdown> countdowns = countdownRepository.findAll();
            Countdown currentCountdown  = countdowns.get(0);
            // when i am in the last countdown, i need to bring the accumulation
            if (currentCountdown.getCount() == 1){
                countdownRepository.delete(currentCountdown);
                int times = accumulationManager.getAccumulation();
                System.out.println("Times that the countdown went off: " + times);

            } else {
                currentCountdown.setCount(currentCountdown.getCount() - 1);
                countdownRepository.save(currentCountdown);
                System.out.println("Countdown at: " + currentCountdown.getCount());
            }

        }
    }

    private Countdown createCountdown(){
        return new Countdown(3);
    }
}
