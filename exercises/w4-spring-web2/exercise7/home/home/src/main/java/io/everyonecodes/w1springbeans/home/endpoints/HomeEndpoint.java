package io.everyonecodes.w1springbeans.home.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {
    @GetMapping
    public String home() {
        return "Kansas";
    }
}
