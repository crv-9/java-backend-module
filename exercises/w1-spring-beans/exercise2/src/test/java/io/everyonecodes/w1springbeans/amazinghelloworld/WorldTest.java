package io.everyonecodes.w1springbeans.amazinghelloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WorldTest {
    @Autowired
    World worldBean;

    @Test
    void get(){
        String result = worldBean.get();
        String expected = "World";

        assertEquals(expected, result);
    }
}
