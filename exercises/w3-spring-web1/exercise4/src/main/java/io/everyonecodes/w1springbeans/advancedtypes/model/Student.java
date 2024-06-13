package io.everyonecodes.w1springbeans.advancedtypes.model;

import java.util.Set;

public class Student {
    String name;
    Set<String> languages;

    public Student() {
    }

    public Student(String name, Set<String> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }
}
