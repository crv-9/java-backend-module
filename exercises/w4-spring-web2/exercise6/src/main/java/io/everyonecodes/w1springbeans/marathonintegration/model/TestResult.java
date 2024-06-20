package io.everyonecodes.w1springbeans.marathonintegration.model;

import java.util.Objects;

public class TestResult {
    String result;
    String message;

    public TestResult(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestResult that)) return false;
        return Objects.equals(result, that.result) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, message);
    }
}
