package io.everyonecodes.w1springbeans.marcopolo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MarcoPoloEndpoint {

    @GetMapping("/{name}")
    String getAnswer(@PathVariable String name) {
        if (name.equals("Marco")) {
            return "Polo";
        } else return "What?";
    }
}
