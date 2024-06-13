package io.everyonecodes.w1springbeans.interactions.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class UpperCaseEndpoint {

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String uppercase) {
        return uppercase.toUpperCase();
    }

}
