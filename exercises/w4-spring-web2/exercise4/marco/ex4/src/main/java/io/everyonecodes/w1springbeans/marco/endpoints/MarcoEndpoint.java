package io.everyonecodes.w1springbeans.marco.endpoints;

import io.everyonecodes.w1springbeans.marco.clients.PoloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MarcoEndpoint {
    private final PoloClient poloClient;

    public MarcoEndpoint(PoloClient poloClient) {
        this.poloClient = poloClient;
    }

    @GetMapping("/marco/{message}")
    public String getMessage(@PathVariable String message){
        return poloClient.forwardToPolo(message);
    }

}
