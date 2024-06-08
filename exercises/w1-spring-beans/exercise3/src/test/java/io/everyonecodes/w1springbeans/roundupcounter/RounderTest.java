package io.everyonecodes.w1springbeans.roundupcounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RounderTest {

    @Autowired
    Rounder rounder;

    @Test
    public void testRoundUp() {
        System.out.println("Up");
        System.out.println(rounder.roundUp(1.2));
    }
    @Test
    public void testRoundDown() {
        System.out.println("Down");
        System.out.println(rounder.roundDown(1.2));
    }
}
