package io.everyonecodes.w1springbeans.advancedtypes.controllers;

import io.everyonecodes.w1springbeans.advancedtypes.config.CommunityEventConfiguration;
import io.everyonecodes.w1springbeans.advancedtypes.model.CommunityEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class CommunityEventEndpoint {
    List<CommunityEvent> communityEvents;

    // this is needed as the bean was not created in config
    public CommunityEventEndpoint(CommunityEventConfiguration communityEventConfiguration) {
        this.communityEvents = communityEventConfiguration.getEvents();
    }

    @GetMapping
    public List<CommunityEvent> getCommunityEvents() {
        return communityEvents;
    }

}
