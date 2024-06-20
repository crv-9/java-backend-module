package io.everyonecodes.w1springbeans.marathonintegration;


import io.everyonecodes.w1springbeans.marathonintegration.logic.MarathonTester;
import io.everyonecodes.w1springbeans.marathonintegration.model.TestResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MarathonIntegrationEndpointTest {
    // here i am pretending that I have an external app trying to use
    // I am trying to reach my own endpoint, make a request to it and see what I will be returning

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MarathonTester marathonTester;

    String url = "/marathon/integration";

    @Test
    void get(){
        TestResult expected = new TestResult("", "");

        // if my service class method depends on a client, then I also need to mock that dependency
        when(marathonTester.runCompleteTest()).thenReturn(expected);

        TestResult actual = restTemplate.getForObject(url, TestResult.class);

        assertEquals(expected, actual);

        verify(marathonTester).runCompleteTest();


    }
}
