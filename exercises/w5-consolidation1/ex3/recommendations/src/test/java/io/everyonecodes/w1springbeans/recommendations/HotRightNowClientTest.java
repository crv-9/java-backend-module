package io.everyonecodes.w1springbeans.recommendations;

import io.everyonecodes.w1springbeans.recommendations.clients.HotRightNowClient;
import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
// with @ActiveProfiles("test") I am telling Spring which yaml file to use.
// make sure you name the yaml file correctly
public class HotRightNowClientTest {
    @Autowired
    HotRightNowClient hotRightNowClient;
    @Autowired
    HotRightNowConfiguration hotRightNowConfiguration;


    @MockBean
    RestTemplate restTemplate;

    String url = "http://localhost.9002/movies";

    @Test
    void getHotRightNowMovies(){
        List<Movie> movies = hotRightNowConfiguration.getMovies();

        when(hotRightNowClient.getHotRightNowMovies()).thenReturn(movies);


        verify(restTemplate).getForObject(url, Movie[].class);

    }
}
