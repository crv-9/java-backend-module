package io.everyonecodes.w1springbeans.roundupcounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpDownIndicatorTest {
    @Autowired
    UpDownIndicator upDownIndicator;

    @Test
    public void testUpDownIndicator() {
        System.out.println(upDownIndicator.indicate(2.2));
        System.out.println(upDownIndicator.indicate(2.5));
        System.out.println(upDownIndicator.indicate(2.8));
    }
}
