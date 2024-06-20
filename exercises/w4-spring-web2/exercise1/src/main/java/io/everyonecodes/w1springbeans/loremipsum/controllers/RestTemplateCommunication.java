package io.everyonecodes.w1springbeans.loremipsum.controllers;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateCommunication {
    RestTemplate restTemplate;
    public RestTemplateCommunication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String url = "https://loripsum.net/api";

    public String getLoremIpsum() {
        return restTemplate.getForObject(url, String.class);
    }
}
