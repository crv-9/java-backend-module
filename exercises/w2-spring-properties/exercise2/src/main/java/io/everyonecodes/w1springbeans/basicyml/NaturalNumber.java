package io.everyonecodes.w1springbeans.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaturalNumber {
    int number;

    public NaturalNumber(@Value("${basic.naturalNumber}") int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
