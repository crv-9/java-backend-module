package io.everyonecodes.w1springbeans.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Message {
    String message;

    public Message(@Value("${basic.message}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
