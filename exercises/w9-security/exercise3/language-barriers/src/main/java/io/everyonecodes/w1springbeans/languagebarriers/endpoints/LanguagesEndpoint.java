package io.everyonecodes.w1springbeans.languagebarriers.endpoints;

import io.everyonecodes.w1springbeans.languagebarriers.logic.InteractionsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LanguagesEndpoint {
    private final InteractionsService interactionsService;

    public LanguagesEndpoint(InteractionsService interactionsService) {
        this.interactionsService = interactionsService;
    }

    @GetMapping
    public String getGeneralAnswer() {
        return "Online Language School";
    }


    @GetMapping("/languages")
    @Secured("ROLE_USER")
    public String getLanguagesAnswer() {
        interactionsService.incrementInteractionsCountByOne();
        return "Our available languages are german and english";
    }


    @GetMapping("/languages/german")
    @Secured({"ROLE_LANGUAGE_GERMAN"})
    public String getGermanAnswer() {
        interactionsService.incrementInteractionsCountByOne();
        return "Willkommen";
    }

    @GetMapping("/languages/english")
    @Secured("ROLE_LANGUAGE_ENGLISH")
    public String getEnglishAnswer() {
        interactionsService.incrementInteractionsCountByOne();
        return "Welcome";
    }


}
