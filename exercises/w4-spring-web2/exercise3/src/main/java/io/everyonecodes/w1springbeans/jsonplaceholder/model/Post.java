package io.everyonecodes.w1springbeans.jsonplaceholder.model;


import java.util.Objects;

/*
* Post. Has title and content as String properties, and user and identifier as int properties.
* */
public class Post {
    String title;
    String content;
    int user;
    int identifier;

    public Post(String title, String content, int user, int identifier) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return user == post.user && identifier == post.identifier && Objects.equals(title, post.title) && Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, user, identifier);
    }
}
