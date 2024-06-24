package io.everyonecodes.w1springbeans.hotrightnow.logic;

import io.everyonecodes.w1springbeans.hotrightnow.config.MovieConfiguration;
import io.everyonecodes.w1springbeans.hotrightnow.model.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MovieStore {

    private final List<Movie> movies;

    public MovieStore(MovieConfiguration movieConfiguration) {
        this.movies = movieConfiguration.getMovies();
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
