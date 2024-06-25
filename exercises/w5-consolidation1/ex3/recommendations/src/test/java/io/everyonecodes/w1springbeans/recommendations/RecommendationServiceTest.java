package io.everyonecodes.w1springbeans.recommendations;

import io.everyonecodes.w1springbeans.recommendations.clients.HotRightNowClient;
import io.everyonecodes.w1springbeans.recommendations.clients.TailoredRecommendationsClient;
import io.everyonecodes.w1springbeans.recommendations.logic.RecommendationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
//        when(recommendationService.getRecommendedMovies(userUuid)).
    }
}
