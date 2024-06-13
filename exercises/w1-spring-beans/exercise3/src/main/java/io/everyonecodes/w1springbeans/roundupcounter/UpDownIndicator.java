package io.everyonecodes.w1springbeans.roundupcounter;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {
    private final Rounder rounder;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double number){
        double differenceUp = rounder.roundUp(number) - number;
        double differenceDown = number - rounder.roundDown(number);

        if (differenceUp > differenceDown) {return "DOWN";}
        else if (differenceUp < differenceDown) {return "UP";} else return "SAME";
    }

}
