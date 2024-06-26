package io.everyonecodes.w1springbeans.dorothy.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Dorothy {
    private final RestTemplate restTemplate;
    private final String wizardUrl;

    public Dorothy(RestTemplate restTemplate,@Value("${answer.url}") String wizardUrl) {
        this.restTemplate = restTemplate;
        this.wizardUrl = wizardUrl;
    }

    public String getHomeInteraction(){
        String urlResponseWizard = contactWizard();
        return "My home is "+ contactHome(urlResponseWizard);
    }

    private String contactWizard(){
        return restTemplate.getForObject(wizardUrl, String.class);
    }

    private String contactHome(String homeUrl){
        return restTemplate.getForObject(homeUrl, String.class);
    }
}
