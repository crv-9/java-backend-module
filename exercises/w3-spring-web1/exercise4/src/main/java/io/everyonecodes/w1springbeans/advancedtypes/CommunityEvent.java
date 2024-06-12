package io.everyonecodes.w1springbeans.advancedtypes;

import java.util.Set;

public class CommunityEvent {
    String name;
    String location;
    Set<Student> students;

    public CommunityEvent() {
    }

    public CommunityEvent(String name, String location, Set<Student> students) {
        this.name = name;
        this.location = location;
        this.students = students;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
