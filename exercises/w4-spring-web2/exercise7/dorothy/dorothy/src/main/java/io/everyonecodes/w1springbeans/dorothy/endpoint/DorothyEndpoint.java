package io.everyonecodes.w1springbeans.dorothy.endpoint;

import io.everyonecodes.w1springbeans.dorothy.logic.Dorothy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dorothy")
public class DorothyEndpoint {

    private final Dorothy dorothy;

    public DorothyEndpoint(Dorothy dorothy) {
        this.dorothy = dorothy;
    }

    @GetMapping
    public String getAnswer(){
        return dorothy.getHomeInteraction();
    }
}
