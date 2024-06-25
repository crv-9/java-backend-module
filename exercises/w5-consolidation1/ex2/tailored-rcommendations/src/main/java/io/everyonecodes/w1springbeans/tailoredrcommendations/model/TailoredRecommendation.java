package io.everyonecodes.w1springbeans.tailoredrcommendations.model;

import java.util.Objects;

public class TailoredRecommendation {
    String userUuid;
    Movie movie;

    public TailoredRecommendation() {
    }

    public TailoredRecommendation(String userUuid, Movie movie) {
        this.userUuid = userUuid;
        this.movie = movie;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TailoredRecommendation that)) return false;
        return Objects.equals(userUuid, that.userUuid) && Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userUuid, movie);
    }

    @Override
    public String toString() {
        return "TailoredRecommendation{" +
                "userUuid='" + userUuid + '\'' +
                ", movie=" + movie +
                '}';
    }
}
