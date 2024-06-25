package io.everyonecodes.w1springbeans.recommendations;


import io.everyonecodes.w1springbeans.recommendations.clients.TailoredRecommendationsClient;
import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TailoredRecommendationsClientTest {
    @Autowired
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @Autowired
    List<Movie> movies;

    @MockBean
    RestTemplate restTemplate;

    String url123 = "http://localhost:9001/tailoredrecommendations/123abc";


    @Test
    void getRecommendations() {
        when(restTemplate.getForObject(url123, Movie[].class))
                .thenReturn(new Movie[]{});

        tailoredRecommendationsClient.getTailoredRecommendations("123abc");

        verify(restTemplate).getForObject(url123, Movie[].class);
    }

}
