package io.everyonecodes.w1springbeans.punchcards.model;

import java.util.Objects;

public class PunchCard {
    String id;
    String dayOfTheWeek;
    String timeOfDay;

    public PunchCard(String id, String dayOfTheWeek, String timeOfDay) {
        this.id = id;
        this.dayOfTheWeek = dayOfTheWeek;
        this.timeOfDay = timeOfDay;
    }

    public PunchCard(String dayOfTheWeek, String timeOfDay) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.timeOfDay = timeOfDay;
    }

    public PunchCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunchCard punchCard)) return false;
        return Objects.equals(id, punchCard.id) && Objects.equals(dayOfTheWeek, punchCard.dayOfTheWeek) && Objects.equals(timeOfDay, punchCard.timeOfDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayOfTheWeek, timeOfDay);
    }

    @Override
    public String toString() {
        return "PunchCard{" +
                "id='" + id + '\'' +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", timeOfDay='" + timeOfDay + '\'' +
                '}';
    }
}
