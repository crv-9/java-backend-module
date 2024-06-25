package io.everyonecodes.w1springbeans.recommendations;

import io.everyonecodes.w1springbeans.recommendations.endpoints.RecommendationEndpoint;
import io.everyonecodes.w1springbeans.recommendations.logic.RecommendationService;
import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecommendationEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RecommendationService recommendationService;

    String url = "/recommendations";

    @Test
    void getRecommendationsByUuid() {
        String userUuid = "123abc";

        testRestTemplate.getForObject(url+"/"+userUuid, Movie[].class);

        verify(recommendationService).getRecommendedMovies(userUuid);
    }


}
