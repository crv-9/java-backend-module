package io.everyonecodes.w1springbeans.recommendations;

import io.everyonecodes.w1springbeans.recommendations.clients.HotRightNowClient;
import io.everyonecodes.w1springbeans.recommendations.clients.TailoredRecommendationsClient;
import io.everyonecodes.w1springbeans.recommendations.logic.RecommendationService;
import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RecommendationServiceTest {
    @Autowired
    private RecommendationService recommendationService;

    @MockBean
    HotRightNowClient hotRightNowClient;

    @MockBean
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @Test
    void getTailoredRecommendations() {
        String userUuid = "123abc";
        List<Movie> expected = List.of(new Movie("Test movie", "Test Syn"));

        when(tailoredRecommendationsClient.getTailoredRecommendations(userUuid)).thenReturn(expected);

        List<Movie> result = recommendationService.getTailoredRecommendations(userUuid);

        assertEquals(expected, result);
    }

    @Test
    void getRecommendationsHotRightNow() {
        String userUuid = "123abc";
        List<Movie> expected = List.of(new Movie("Another movie", "Another Syn"));

        when(tailoredRecommendationsClient.getTailoredRecommendations(userUuid)).thenReturn(expected);
        when(hotRightNowClient.getHotRightNowMovies()).thenReturn(expected);


        List<Movie> result = recommendationService.getTailoredRecommendations(userUuid);

        assertEquals(expected, result);
    }
}
