package io.everyonecodes.w1springbeans.advancedtypes.config;

import io.everyonecodes.w1springbeans.advancedtypes.model.CommunityEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("education")
public class CommunityEventConfiguration {
    List<CommunityEvent> events;

    public List<CommunityEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CommunityEvent> events) {
        this.events = events;
    }
}
