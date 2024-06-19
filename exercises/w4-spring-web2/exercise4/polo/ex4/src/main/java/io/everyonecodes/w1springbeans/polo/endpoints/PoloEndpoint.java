package io.everyonecodes.w1springbeans.polo.endpoints;

import io.everyonecodes.w1springbeans.polo.logic.Polo;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoloEndpoint {
    private final Polo polo;
    public PoloEndpoint(Polo polo) {
        this.polo = polo;
    }

    @PostMapping("/polo")
    public String postToPolo(@RequestBody String message) {
        return polo.giveAnswer(message);
    }

}
