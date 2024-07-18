package io.everyonecodes.w1springbeans.punchcards;

import io.everyonecodes.w1springbeans.punchcards.config.PunchCardRunner;
import io.everyonecodes.w1springbeans.punchcards.logic.PunchCardService;
import io.everyonecodes.w1springbeans.punchcards.model.PunchCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PunchCardServiceTest {
    @Autowired
    private PunchCardService punchCardService;

    @MockBean
    PunchCardRunner punchCardRunner;

//    @Test
//    void testPunchCard() {
//        punchCardService.save(new PunchCard());
//
//
//    }
}
