package io.everyonecodes.w1springbeans.hotrightnow;



import io.everyonecodes.w1springbeans.hotrightnow.logic.MovieStore;
import io.everyonecodes.w1springbeans.hotrightnow.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test") //
// with @ActiveProfiles("test") I am telling Spring which yaml file to use.
// make sure you name the yaml file correctly
public class MovieStoreTest {
    @Autowired
    private MovieStore movieStore;

    // finding if all movies are there
    @Test
    void testMovieStore() {
        List<Movie> movies = movieStore.getMovies();
        assertEquals(3, movies.size());
        assertEquals("The Matrix", movies.get(0).getTitle());
        assertEquals("Inception", movies.get(1).getTitle());
        assertEquals("Interstellar", movies.get(2).getTitle());
    }

    // printing all movies retrieved
    @Test
    void getMovies(){
        List<Movie> movies = movieStore.getMovies();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }





}
