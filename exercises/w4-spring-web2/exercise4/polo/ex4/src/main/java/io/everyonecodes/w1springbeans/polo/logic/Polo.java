package io.everyonecodes.w1springbeans.polo.logic;

import org.springframework.stereotype.Service;

@Service
public class Polo {
    public String giveAnswer(String message) {
        return message.equals("Marco")? "Polo":"What?";
    }
}
