package io.everyonecodes.w1springbeans.complexformula.clients;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class FormulaClient {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8080/formula";

    public FormulaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // here i am posting the numberAsString to the interactions endpoint
    public int sendAndCalculateNumber(String numberAsString){
        return restTemplate.postForObject(url, numberAsString, Integer.class);
    }
}
