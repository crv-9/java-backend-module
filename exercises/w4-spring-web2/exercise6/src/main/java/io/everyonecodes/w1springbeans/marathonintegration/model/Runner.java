package io.everyonecodes.w1springbeans.marathonintegration.model;

import java.time.Duration;
import java.util.Objects;

public class Runner {
    String name;
    Duration duration;

    public Runner(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public Runner() {
    }

    public Runner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Runner runner)) return false;
        return Objects.equals(name, runner.name) && Objects.equals(duration, runner.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
