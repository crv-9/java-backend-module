package io.everyonecodes.w1springbeans.marco.clients;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PoloClient {
    private final RestTemplate restTemplate;
    private final String poloUrl = "http://localhost:9001/polo";

    public PoloClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String forwardToPolo(String message){
        return restTemplate.postForObject(this.poloUrl, message, String.class);
    }



}
