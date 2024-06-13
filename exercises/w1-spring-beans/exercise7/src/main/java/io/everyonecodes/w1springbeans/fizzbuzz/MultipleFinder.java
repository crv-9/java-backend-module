package io.everyonecodes.w1springbeans.fizzbuzz;

public class MultipleFinder {
    int multiple;

    public MultipleFinder(int multiple) {
        this.multiple = multiple;
    }

    public boolean isMultiple(int number) {
        return number % multiple == 0;
    }
}
