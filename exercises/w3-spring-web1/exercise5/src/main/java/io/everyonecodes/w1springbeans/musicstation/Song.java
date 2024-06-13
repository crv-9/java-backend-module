package io.everyonecodes.w1springbeans.musicstation;

import java.util.Objects;

public class Song {
    String name;
    String genre;

    public Song() {
    }

    public Song(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return Objects.equals(name, song.name) && Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre);
    }
}
