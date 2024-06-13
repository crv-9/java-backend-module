package io.everyonecodes.w1springbeans.interactions.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormulaEndpoint {
    @PostMapping("/formula")
    public int getDouble(@RequestBody String numberString){

        return Integer.parseInt(numberString)*2;
    }
}
