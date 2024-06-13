package io.everyonecodes.w1springbeans.marathon.controllers;

import io.everyonecodes.w1springbeans.marathon.model.MarathonService;
import io.everyonecodes.w1springbeans.marathon.model.Runner;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {
    MarathonService marathonService;
    public MarathonEndpoint(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @PostMapping
    public Runner addRunner(@RequestBody Runner runner){
        marathonService.addRunner(runner);
        return runner;
    }

    @GetMapping
    public Set<Runner> getAllRunners(){
        return marathonService.getRunners();
    }

    @GetMapping("/winner")
    public Runner getWinner(){
        return marathonService.findWinner();
    }



}
