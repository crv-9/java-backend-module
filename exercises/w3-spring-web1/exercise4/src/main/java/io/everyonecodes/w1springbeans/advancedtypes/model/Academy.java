package io.everyonecodes.w1springbeans.advancedtypes.model;

public class Academy {
    String name;
    String location;

    public Academy() {
    }

    public Academy(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
