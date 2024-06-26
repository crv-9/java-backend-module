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


    // why am I not using a bean? and why does it work?
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    // here I am including the constructor, but apparently it isn;t needed
    public MovieStore() {
        this.movies = getMovies();
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
