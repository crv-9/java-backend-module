package io.everyonecodes.w1springbeans.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Choice {
    boolean choice;

    public Choice(@Value("${basic.choice}") boolean choice) {
        this.choice = choice;
    }
}
