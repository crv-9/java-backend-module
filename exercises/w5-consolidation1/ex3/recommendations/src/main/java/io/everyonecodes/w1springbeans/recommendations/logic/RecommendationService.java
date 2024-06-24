package io.everyonecodes.w1springbeans.recommendations.logic;

import io.everyonecodes.w1springbeans.recommendations.clients.HotRightNowClient;
import io.everyonecodes.w1springbeans.recommendations.clients.TailoredRecommendationsClient;
import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final HotRightNowClient hotRightNowClient;
    private final TailoredRecommendationsClient tailoredRecommendationsClient;

    public RecommendationService(HotRightNowClient hotRightNowClient, TailoredRecommendationsClient tailoredRecommendationsClient) {
        this.hotRightNowClient = hotRightNowClient;
        this.tailoredRecommendationsClient = tailoredRecommendationsClient;
    }

    public List<Movie> getRecommendedMovies(String userUuid) {
        List<Movie> tailoredMovies =  getTailoredRecommendations(userUuid);
        if (tailoredMovies.isEmpty()){
            return getHotRightNowMovies();
        } else return tailoredMovies;
    }

    public List<Movie> getTailoredRecommendations(String userUuid) {
        return tailoredRecommendationsClient.getTailoredRecommendations(userUuid);
    }

    public List<Movie> getHotRightNowMovies() {
        return hotRightNowClient.getHotRightNowMovies();
    }

}
