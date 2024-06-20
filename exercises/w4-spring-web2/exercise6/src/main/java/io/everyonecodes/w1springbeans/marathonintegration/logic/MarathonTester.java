package io.everyonecodes.w1springbeans.marathonintegration.logic;

import io.everyonecodes.w1springbeans.marathonintegration.clients.MarathonClient;
import io.everyonecodes.w1springbeans.marathonintegration.config.RunnerConfiguration;
import io.everyonecodes.w1springbeans.marathonintegration.model.Runner;
import io.everyonecodes.w1springbeans.marathonintegration.model.TestResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.xml.datatype.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonTester {

    private final MarathonClient marathonClient;
    private final List<Runner> runners;
    private final Runner winner;


    public MarathonTester(MarathonClient marathonClient, RunnerConfiguration runnerConfiguration) {
        this.marathonClient = marathonClient;
        this.runners = runnerConfiguration.getRunners();
        this.winner = runnerConfiguration.getWinner();

    }

//    public String testList(){
//        //System.out.println(runners);
//        return "expected winner: " + winner;
//    }

    public TestResult runCompleteTest(){
        if (getMarathonWinner().isEmpty()){// run next part
            runners.forEach(this::postARunner); // post several runners
            runners.forEach(System.out::println);
            if (getMarathonWinner().get().getName().equals(winner.getName())){ // ask for winner again
                return new TestResult("Success", "Tests run correctly"); // return success TestResult
            } else return new TestResult("Error", "Incorrect winner received"); // return wrong winner TestResult
        } else return new TestResult("Error", "No winner should have been received in the first call");// return fail first call TestResult
    }

    public Optional<Runner> getMarathonWinner() {
        return marathonClient.getWinner();
    }

    public void postARunner(Runner runner){
        marathonClient.postRunner(runner);
    }



}
