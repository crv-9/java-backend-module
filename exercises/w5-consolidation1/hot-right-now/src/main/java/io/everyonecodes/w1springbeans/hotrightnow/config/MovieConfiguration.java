package io.everyonecodes.w1springbeans.hotrightnow.config;

import io.everyonecodes.w1springbeans.hotrightnow.model.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("store")
public class MovieConfiguration {
    private List<Movie> movies;

    @Bean
    public List<Movie> getMovies() {
        return movies;
    }

    void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
