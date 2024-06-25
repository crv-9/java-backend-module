package io.everyonecodes.w1springbeans.tailoredrcommendations;

import io.everyonecodes.w1springbeans.tailoredrcommendations.logic.TailoredRecommendationsStore;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.Movie;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.TailoredRecommendation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TailoredRecommendationsStoreTest {
    @Autowired
    private TailoredRecommendationsStore tailoredRecommendationsStore;

    @Test
    public void testStore() {
        List<TailoredRecommendation> recommendations = tailoredRecommendationsStore.getRecommendations();

        assertEquals(2, recommendations.size());

        recommendations.forEach(System.out::println);
        for (TailoredRecommendation recommendation : recommendations) {
            System.out.println(recommendation.getUserUuid());
        }
    }
}
