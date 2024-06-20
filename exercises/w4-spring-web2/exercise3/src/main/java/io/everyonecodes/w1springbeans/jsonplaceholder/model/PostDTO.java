package io.everyonecodes.w1springbeans.jsonplaceholder.model;

/*
* PostDTO. Has title and body as String properties, and userId and id as int properties.
* */

import java.util.Objects;

public class PostDTO {
    String title;
    String body;
    int userId;
    int id;

    public PostDTO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDTO postDTO)) return false;
        return userId == postDTO.userId && id == postDTO.id && Objects.equals(title, postDTO.title) && Objects.equals(body, postDTO.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, userId, id);
    }
}
