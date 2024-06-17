package io.everyonecodes.w1springbeans.mocky.controllers;


import io.everyonecodes.w1springbeans.mocky.config.RestTemplateCommunication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mocky/texts")
public class MockyTextsEndpoint {

    private final RestTemplateCommunication restTemplateCommunication;

    public MockyTextsEndpoint(RestTemplateCommunication restTemplateCommunication) {
        this.restTemplateCommunication = restTemplateCommunication;
    }

    @GetMapping("/1")
    public String getSingleString(){
        return restTemplateCommunication.getSingleString();
    }
    @GetMapping("/2")
    public String getArrayString(){
        return restTemplateCommunication.getArrayString();
    }

}
