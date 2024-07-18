package io.everyonecodes.w1springbeans.thefinalcountdown.logic;

import io.everyonecodes.w1springbeans.thefinalcountdown.model.Accumulation;
import io.everyonecodes.w1springbeans.thefinalcountdown.model.AccumulationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccumulationManager {

    AccumulationRepository accumulationRepository;

    public AccumulationManager(AccumulationRepository accumulationRepository) {
        this.accumulationRepository = accumulationRepository;
    }
    // Currently it can go forever, I could add a limit that when it reaches e.g. 10, it will delete the accumulation too

    public int getAccumulation(){
        if(accumulationRepository.count() == 0){
            accumulationRepository.save(createAccumulation());
            return 1;
        }

        else{
            List<Accumulation> accumulations = accumulationRepository.findAll();
            Accumulation currentAccumulation = accumulations.get(0);

            // this could be into one line, but harder to read
            int currentTimes = currentAccumulation.getTimes();
            currentTimes++;
            currentAccumulation.setTimes(currentTimes);
            accumulationRepository.save(currentAccumulation);
            return currentTimes;
        }

    }

    private Accumulation createAccumulation() {
        return new Accumulation(1);
    }
}
