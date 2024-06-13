package io.everyonecodes.w1springbeans.advancedyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class DecimalNumber {
    double decimalNumber;


    public double getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(double decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
}
