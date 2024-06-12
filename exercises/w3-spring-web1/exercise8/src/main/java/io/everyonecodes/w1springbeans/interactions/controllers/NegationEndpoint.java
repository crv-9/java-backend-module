package io.everyonecodes.w1springbeans.interactions.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NegationEndpoint {
    @PostMapping("/negation")
    public boolean getNegation(@RequestBody String input) {
        return !Boolean.parseBoolean(input);
    }
}
