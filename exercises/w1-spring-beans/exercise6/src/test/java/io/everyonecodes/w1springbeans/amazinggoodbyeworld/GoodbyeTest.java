package io.everyonecodes.w1springbeans.amazinggoodbyeworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GoodbyeTest {

    @Autowired
    Goodbye goodbye;

    @Test
    public void testGoodbye() {
        String result = goodbye.get();
        assertEquals("Goodbye", result);
    }

}
