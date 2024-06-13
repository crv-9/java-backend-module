package io.everyonecodes.w1springbeans.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DecimalNumber {
    double number;

    public DecimalNumber(@Value("${basic.decimalNumber}") double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }
}
