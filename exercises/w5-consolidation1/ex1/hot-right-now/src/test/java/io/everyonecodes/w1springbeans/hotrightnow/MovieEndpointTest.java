package io.everyonecodes.w1springbeans.hotrightnow;

import io.everyonecodes.w1springbeans.hotrightnow.logic.MovieStore;
import io.everyonecodes.w1springbeans.hotrightnow.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieEndpointTest {

    // why do this? it doesn't make sense. i don't user restTemplate in this app. is it for mocking?
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MovieStore movieStore;

    String url = "/movies";

    // what am I testing or asserting?
    @Test
    void getMovies() {
        restTemplate.getForObject(url, Movie[].class);

        verify(movieStore).getMovies();
    }


}
