package io.everyonecodes.w1springbeans.recommendations.clients;

import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class HotRightNowClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9002/movies";

    public HotRightNowClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // I want to get the list of Movies, but we can't receive a List<Object> as a normal class type
    // we'll use the following instead

    public List<Movie> getHotRightNowMovies(){
        Movie[] moviesArray = restTemplate.getForObject(url, Movie[].class);
        return Arrays.asList(moviesArray);
    }


}