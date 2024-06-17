package io.everyonecodes.w1springbeans.mocky.controllers;


import io.everyonecodes.w1springbeans.mocky.config.RestTemplateCommunication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mocky/postcards")
public class MockyPostcardsEndpoint {

    private final RestTemplateCommunication restTemplateCommunication;

    public MockyPostcardsEndpoint(RestTemplateCommunication restTemplateCommunication) {
        this.restTemplateCommunication = restTemplateCommunication;
    }

    @GetMapping("/1")
    public String getSinglePostcard(){
        return restTemplateCommunication.getSinglePostcard();
    }
    @GetMapping("/2")
    public String getListPostcards(){
        return restTemplateCommunication.getListPostcard();
    }

}
