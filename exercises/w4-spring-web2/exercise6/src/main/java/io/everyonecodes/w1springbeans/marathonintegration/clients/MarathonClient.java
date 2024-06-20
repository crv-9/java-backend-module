package io.everyonecodes.w1springbeans.marathonintegration.clients;

import io.everyonecodes.w1springbeans.marathonintegration.model.Runner;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class MarathonClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8500/runners";

    public MarathonClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<Runner> getWinner(){
        return Optional.ofNullable(restTemplate.getForObject(url + "/winner", Runner.class));
    }

    public Runner postRunner(Runner runner){
        return restTemplate.postForObject(url, runner, Runner.class);
    }


}
