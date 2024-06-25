package io.everyonecodes.w1springbeans.recommendations;

import io.everyonecodes.w1springbeans.recommendations.model.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("hot-store-test")
public class HotRightNowConfiguration {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
