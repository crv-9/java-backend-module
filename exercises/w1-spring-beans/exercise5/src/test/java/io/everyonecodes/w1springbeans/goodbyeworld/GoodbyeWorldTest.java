package io.everyonecodes.w1springbeans.goodbyeworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GoodbyeWorldTest {

    @Autowired
    GoodbyeWorld goodbyeWorld;

    @Test
    void goodbyeWorld() {

        String result = goodbyeWorld.get();

        assertEquals("Goodbye World", result);

    }

}
