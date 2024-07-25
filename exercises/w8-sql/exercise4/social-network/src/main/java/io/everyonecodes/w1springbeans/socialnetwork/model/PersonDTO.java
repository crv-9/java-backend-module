package io.everyonecodes.w1springbeans.socialnetwork.model;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    Long id;
    String name;
    List<String> friendNames = new ArrayList<>();

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, List<String> friendNames) {
        this.id = id;
        this.name = name;
        this.friendNames = friendNames;
    }

    public PersonDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonDTO(String name, List<String> friendNames) {
        this.name = name;
        this.friendNames = friendNames;
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

    public List<String> getFriendNames() {
        return friendNames;
    }

    public void setFriendNames(List<String> friendNames) {
        this.friendNames = friendNames;
    }
}
