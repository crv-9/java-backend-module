package io.everyonecodes.w1springbeans.advancedyml;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class NaturalNumber {
    int naturalNumber;

    public int getNaturalNumber() {
        return naturalNumber;
    }

    public void setNaturalNumber(int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }
}
