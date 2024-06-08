package io.everyonecodes.w1springbeans.roundupcounter;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpCounter {
    UpDownIndicator upDownIndicator;

    public UpCounter(UpDownIndicator upDownIndicator) {
        this.upDownIndicator = upDownIndicator;
    }

    public int count(List<Double> numbers) {
        int count = 0;

        for (Double number : numbers) {
            if (upDownIndicator.indicate(number).equals("UP")){
                count++;
            }
        }

        return count;
    }
}
