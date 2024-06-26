package io.everyonecodes.w1springbeans.tailoredrcommendations.endpoints;

import io.everyonecodes.w1springbeans.tailoredrcommendations.logic.TailoredRecommendationsStore;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.Movie;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.TailoredRecommendation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tailoredrecommendations")
public class TailoredRecommendationsEndpoint {

    private final TailoredRecommendationsStore tailoredRecommendationsStore;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore tailoredRecommendationsStore) {
        this.tailoredRecommendationsStore = tailoredRecommendationsStore;
    }

    @GetMapping("/{userUuid}")
    public List<Movie> getRecommendations(@PathVariable("userUuid") String userUuid) {
        return tailoredRecommendationsStore.findRecommendationsByUserUuid(userUuid);
    }

    @PostMapping
    public TailoredRecommendation addRecommendation(@RequestBody TailoredRecommendation tailoredRecommendation) {
        tailoredRecommendationsStore.addTailoredRecommendation(tailoredRecommendation);
        return tailoredRecommendation;
    }
}
