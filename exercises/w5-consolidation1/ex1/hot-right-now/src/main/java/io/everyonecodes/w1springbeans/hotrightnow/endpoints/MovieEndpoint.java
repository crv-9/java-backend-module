package io.everyonecodes.w1springbeans.hotrightnow.endpoints;

import io.everyonecodes.w1springbeans.hotrightnow.logic.MovieStore;
import io.everyonecodes.w1springbeans.hotrightnow.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieEndpoint {
    private final MovieStore movieStore;

    public MovieEndpoint(MovieStore movieStore) {
        this.movieStore = movieStore;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieStore.getMovies();
    }

}
