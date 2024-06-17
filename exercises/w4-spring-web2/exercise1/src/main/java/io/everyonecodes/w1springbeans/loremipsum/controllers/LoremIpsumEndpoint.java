package io.everyonecodes.w1springbeans.loremipsum.controllers;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/loremipsum")
public class LoremIpsumEndpoint {

    private final RestTemplateCommunication restTemplateCommunication;

    public LoremIpsumEndpoint(RestTemplateCommunication restTemplateCommunication) {
        this.restTemplateCommunication = restTemplateCommunication;
    }

    @GetMapping
    public String getLoremIpsum() {
        return restTemplateCommunication.getLoremIpsum();
    }


}
