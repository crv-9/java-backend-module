package io.everyonecodes.w1springbeans.threepwoodcinema;

public class Template {
    String name;
    String keyword;
    String message;

    public Template(String name, String keyword, String message) {
        this.name = name;
        this.keyword = keyword;
        this.message = message;
    }

    public Template() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
