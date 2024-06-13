package io.everyonecodes.w1springbeans.drinks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessengerEndpoint {

    @GetMapping
    String getMessage(){
        return "How are you?";
    }
}
