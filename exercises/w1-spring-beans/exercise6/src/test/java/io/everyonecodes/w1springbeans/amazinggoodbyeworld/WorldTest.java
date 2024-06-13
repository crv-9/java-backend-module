package io.everyonecodes.w1springbeans.amazinggoodbyeworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WorldTest {

    @Autowired
    World world;

    @Test
    void getWorld(){
        String result = world.get();
        assertEquals("World", result);
    }
}
