package io.everyonecodes.w1springbeans.thefinalcountdown.model;

import java.util.Objects;

public class Countdown {
    String id;
    int count;

    public Countdown(String id, int count) {
        this.id = id;
        this.count = count;
    }

    public Countdown(int count) {
        this.count = count;
    }

    public Countdown() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Countdown countdown)) return false;
        return count == countdown.count && Objects.equals(id, countdown.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }

    @Override
    public String toString() {
        return "Countdown{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
