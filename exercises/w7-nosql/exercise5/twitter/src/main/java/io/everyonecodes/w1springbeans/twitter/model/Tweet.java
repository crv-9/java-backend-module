package io.everyonecodes.w1springbeans.twitter.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tweet {
    String id;
    String user;
    String text;

    int likes;
    List<String> comments = new ArrayList<>();

    LocalDateTime timestamp;

    public Tweet() {
    }

    public Tweet(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public Tweet(String id, String user, String text, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Tweet(String id, String user, String text, int likes, List<String> comments, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.likes = likes;
        this.comments = comments;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet tweet)) return false;
        return likes == tweet.likes && Objects.equals(id, tweet.id) && Objects.equals(user, tweet.user) && Objects.equals(text, tweet.text) && Objects.equals(comments, tweet.comments) && Objects.equals(timestamp, tweet.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, text, likes, comments, timestamp);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", text='" + text + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", timestamp=" + timestamp +
                '}';
    }
}
