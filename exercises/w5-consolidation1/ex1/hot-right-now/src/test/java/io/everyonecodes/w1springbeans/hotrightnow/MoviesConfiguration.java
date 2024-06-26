package io.everyonecodes.w1springbeans.hotrightnow;

import io.everyonecodes.w1springbeans.hotrightnow.model.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.List;

@Configuration
@ConfigurationProperties("store-test")
public class MoviesConfiguration {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
