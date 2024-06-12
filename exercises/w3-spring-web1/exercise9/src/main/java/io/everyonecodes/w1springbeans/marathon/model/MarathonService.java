package io.everyonecodes.w1springbeans.marathon.model;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@Service
public class MarathonService {
    Set<Runner> runners = new HashSet<>();

    public void setRunners(Set<Runner> runners) {
        this.runners = runners;
    }

    public void addRunner(Runner runner) {
        runners.add(runner);
    }

    public Runner findWinner(){
        return runners.stream()
                .min(Comparator.comparing(Runner::getDuration))
                .orElse(null);
    }

    public Set<Runner> getRunners() {
        return runners;
    }

}
