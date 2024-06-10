package io.everyonecodes.w1springbeans.amazinggoodbyeworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AmazingGoodbyeWorldTest {
    @Autowired
    AmazingGoodbyeWorld amazingGoodbyeWorld;

    @Test
    void amazingGoodbyeWorld() {
        String result = amazingGoodbyeWorld.get();
        assertEquals("Goodbye World", result);
    }
}
