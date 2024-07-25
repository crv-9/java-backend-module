package io.everyonecodes.w1springbeans.socialnetwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue
    Long id;
    String name;

    @ManyToMany
    List<Person> friends;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, List<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    public Person(Long id, String name, List<Person> friends) {
        this.id = id;
        this.name = name;
        this.friends = friends;
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

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
