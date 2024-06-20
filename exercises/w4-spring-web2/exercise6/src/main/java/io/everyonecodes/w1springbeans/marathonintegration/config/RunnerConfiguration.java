package io.everyonecodes.w1springbeans.marathonintegration.config;

import io.everyonecodes.w1springbeans.marathonintegration.model.Runner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

// here i am plugging in the winner Runner bean AND the runners list of Runner bean

@Configuration
@ConfigurationProperties("marathon")
public class RunnerConfiguration {

    // it is with these names that springboot knows how to assign them from the yaml file
    private List<Runner> runners;
    private Runner winner;

    @Bean
    public List<Runner> getRunners() {
        return runners;
    }

    void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    @Bean
    public Runner getWinner() {
        return winner;
    }
    void setWinner(Runner winner) {this.winner = winner;}
}
