package io.everyonecodes.w1springbeans.simplehello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloEndpoint {
    @GetMapping
    String get(){
        return "Hello!";
    }
}
