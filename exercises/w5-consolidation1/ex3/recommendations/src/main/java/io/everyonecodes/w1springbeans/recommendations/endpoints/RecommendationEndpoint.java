package io.everyonecodes.w1springbeans.recommendations.endpoints;

import io.everyonecodes.w1springbeans.recommendations.logic.RecommendationService;
import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEndpoint {
    private final RecommendationService recommendationService;
    public RecommendationEndpoint(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{userUuid}")
    public List<Movie> getMovies(@PathVariable String userUuid) {
        return recommendationService.getRecommendedMovies(userUuid);
    }


}
