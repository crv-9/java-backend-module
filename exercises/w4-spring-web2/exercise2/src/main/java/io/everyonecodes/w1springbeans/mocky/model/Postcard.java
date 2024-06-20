package io.everyonecodes.w1springbeans.mocky.model;

import java.util.Objects;

public class Postcard {
    String from;
    String to;
    String text;

    public Postcard(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postcard postcard)) return false;
        return Objects.equals(from, postcard.from) && Objects.equals(to, postcard.to) && Objects.equals(text, postcard.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, text);
    }
}
