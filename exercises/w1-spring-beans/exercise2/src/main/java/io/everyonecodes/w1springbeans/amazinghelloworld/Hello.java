package io.everyonecodes.w1springbeans.amazinghelloworld;

import org.springframework.stereotype.Service;

@Service
public class Hello {
    public String get(){
        return "Hello";
    }
}
