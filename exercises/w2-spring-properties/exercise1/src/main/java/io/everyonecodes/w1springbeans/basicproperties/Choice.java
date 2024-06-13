package io.everyonecodes.w1springbeans.basicproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Choice {
    boolean choice;

    public Choice(@Value("${basic.choice}") boolean choice) {
        this.choice = choice;
    }
}
