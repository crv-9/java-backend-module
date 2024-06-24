package io.everyonecodes.w1springbeans.hotrightnow.model;

import java.util.Objects;

public class Movie {
    String title;
    String synopsis;

    public Movie() {
    }

    public Movie(String title, String synopsis) {
        this.title = title;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(title, movie.title) && Objects.equals(synopsis, movie.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, synopsis);
    }
}
