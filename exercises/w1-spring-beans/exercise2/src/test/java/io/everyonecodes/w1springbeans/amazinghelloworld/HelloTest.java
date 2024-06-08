package io.everyonecodes.w1springbeans.amazinghelloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloTest {
    @Autowired
    Hello helloBean;

    @Test
    void get(){
        String result = helloBean.get();
        String expected = "Hello";

        assertEquals(expected, result);
    }

}
