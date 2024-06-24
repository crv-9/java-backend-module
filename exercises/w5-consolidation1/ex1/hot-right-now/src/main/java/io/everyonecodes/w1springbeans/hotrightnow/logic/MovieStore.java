package io.everyonecodes.w1springbeans.hotrightnow.logic;


import io.everyonecodes.w1springbeans.hotrightnow.model.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@ConfigurationProperties("store")
public class MovieStore {

    private List<Movie> movies;

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public MovieStore() {
        this.movies = getMovies();
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
