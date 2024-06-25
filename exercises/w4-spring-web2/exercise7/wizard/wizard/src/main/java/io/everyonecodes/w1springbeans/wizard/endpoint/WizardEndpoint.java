package io.everyonecodes.w1springbeans.wizard.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {
    @GetMapping
    public String getHomeURL(@Value("${answer.url}") String url){
        return url;
    }
}
