package io.everyonecodes.w1springbeans.tailoredrcommendations.logic;

import io.everyonecodes.w1springbeans.tailoredrcommendations.model.Movie;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.TailoredRecommendation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConfigurationProperties("store")
public class TailoredRecommendationsStore {

    private List<TailoredRecommendation> recommendations = new ArrayList<>();

    // Class constructor
    public TailoredRecommendationsStore() {
        this.recommendations = getRecommendations();
    }

    // method to get the recommendations list
    public List<TailoredRecommendation> getRecommendations() {
        return recommendations;
    }

    // method I will use to obtain the recommendations list based on userUuid
    public List<Movie> findRecommendationsByUserUuid(String userUuid) {
        return recommendations.stream()
                .filter(tailoredRecommendation -> tailoredRecommendation.getUserUuid().equals(userUuid))
                .map(TailoredRecommendation::getMovie)
                .toList();
    }

    // method to add tailoredRecommendation
    public void addTailoredRecommendation(TailoredRecommendation tailoredRecommendation) {
        recommendations.add(tailoredRecommendation);
    }

    // what does this one do? where is it being used?
    public void setRecommendations(List<TailoredRecommendation> recommendations) {
        this.recommendations = recommendations;
    }




}
