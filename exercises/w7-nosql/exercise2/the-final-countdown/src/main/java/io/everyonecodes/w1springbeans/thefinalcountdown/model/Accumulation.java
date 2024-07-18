package io.everyonecodes.w1springbeans.thefinalcountdown.model;

import java.util.Objects;

public class Accumulation {
    String id;
    int times;

    public Accumulation() {
    }

    public Accumulation(int times) {
        this.times = times;
    }

    public Accumulation(String id, int times) {
        this.id = id;
        this.times = times;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accumulation that)) return false;
        return times == that.times && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, times);
    }

    @Override
    public String toString() {
        return "Accumulation{" +
                "id='" + id + '\'' +
                ", times=" + times +
                '}';
    }
}
