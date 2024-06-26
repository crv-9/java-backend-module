package io.everyonecodes.w1springbeans.tailoredrcommendations;

import io.everyonecodes.w1springbeans.tailoredrcommendations.model.TailoredRecommendation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("store-test")
public class TailoredRecommendationConfiguration {
    private List<TailoredRecommendation> recommendations;

    public List<TailoredRecommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<TailoredRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

}
