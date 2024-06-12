package io.everyonecodes.w1springbeans.advancedtypes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class CommunityEventEndpoint {
    List<CommunityEvent> communityEvents;

    public CommunityEventEndpoint(CommunityEventConfiguration communityEventConfiguration) {
        this.communityEvents = communityEventConfiguration.getEvents();
    }

    @GetMapping
    public List<CommunityEvent> getCommunityEvents() {
        return communityEvents;
    }

}
