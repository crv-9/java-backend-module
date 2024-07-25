package io.everyonecodes.w1springbeans.couchpotato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Film {

    @Id
    @GeneratedValue
    Long id;
    String name;
    int rating;

    public Film() {
    }

    public Film(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Film(Long id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film film)) return false;
        return rating == film.rating && Objects.equals(id, film.id) && Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
