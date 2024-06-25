package io.everyonecodes.w1springbeans.recommendations.clients;


import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class TailoredRecommendationsClient {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9001/tailoredrecommendations/";

    public TailoredRecommendationsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getTailoredRecommendations(String userUuid) {
        String newUrl = url + userUuid;

        Movie[] moviesArray = restTemplate.getForObject(newUrl, Movie[].class);
        return Stream.of(moviesArray).toList();
    }
}
