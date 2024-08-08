package io.everyonecodes.w1springbeans.thethievesden.controllers;

import io.everyonecodes.w1springbeans.thethievesden.logic.AliBabaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// in this exercise I am simply giving the user and pwd in the yaml file
// when doing the GET i only add basic auth with the user and pwd

@RestController
@RequestMapping("/treasures")
public class AliBabaEndpoint {

    private AliBabaService aliBabaService;

    public AliBabaEndpoint(AliBabaService aliBabaService) {
        this.aliBabaService = aliBabaService;
    }

    @GetMapping
    public String getResponse(){
        return aliBabaService.getString();
    }
}
