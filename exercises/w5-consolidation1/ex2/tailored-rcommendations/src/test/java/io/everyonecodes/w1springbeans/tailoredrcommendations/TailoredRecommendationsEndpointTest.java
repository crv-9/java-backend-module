package io.everyonecodes.w1springbeans.tailoredrcommendations;

import io.everyonecodes.w1springbeans.tailoredrcommendations.endpoints.TailoredRecommendationsEndpoint;
import io.everyonecodes.w1springbeans.tailoredrcommendations.logic.TailoredRecommendationsStore;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TailoredRecommendationsEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TailoredRecommendationsStore tailoredRecommendationsStore;

    String url = "/tailoredrecommendations/";

    // Don't I need an assertion here?
    @Test
    void getAllRecommendations() {
        String userUuid = "123abc";
        restTemplate.getForObject(url + userUuid, Movie[].class);

        verify(tailoredRecommendationsStore).findRecommendationsByUserUuid(userUuid);
    }


}
