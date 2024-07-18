package io.everyonecodes.w1springbeans.todos.model;

import java.util.Objects;

public class ToDo {
    String id;
    String title;
    boolean done;

    public ToDo() {
    }

    public ToDo(String title) {
        this.title = title;
        this.done = false;
    }

    public ToDo(String id, String title) {
        this.id = id;
        this.title = title;
        this.done = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo toDo)) return false;
        return done == toDo.done && Objects.equals(id, toDo.id) && Objects.equals(title, toDo.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, done);
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", done=" + done +
                '}';
    }
}
