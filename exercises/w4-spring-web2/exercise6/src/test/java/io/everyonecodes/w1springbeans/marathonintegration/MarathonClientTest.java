package io.everyonecodes.w1springbeans.marathonintegration;

import io.everyonecodes.w1springbeans.marathonintegration.clients.MarathonClient;
import io.everyonecodes.w1springbeans.marathonintegration.model.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MarathonClientTest {

    @Autowired
    MarathonClient marathonClient;

    @MockBean
    RestTemplate restTemplate;

    String runnerURL = "http://localhost:8500/runners";
    String winnerURL = "http://localhost:8500/runners/winner";

    Runner runner = new Runner("Test", Duration.parse("PT1H1M1S"));

    @Test
    void post(){
        // here we are testing if the post we do to another website returns what we expect it
        when(restTemplate.postForObject(runnerURL, runner, Runner.class))
                .thenReturn(runner);
        Runner response = marathonClient.postRunner(runner);
        assertEquals(runner, response);
        // here I need to verify that restTemplate has been used when calling the postForObject
        verify(restTemplate).postForObject(runnerURL, runner, Runner.class);
    }

    @Test
    void getWinner(){

        // here we will be mocking what the other/external application should return
        when(restTemplate.getForObject(winnerURL, Runner.class))
                .thenReturn(runner);

        Optional<Runner> oWinner = Optional.of(runner); // expected
        Optional<Runner> oResponse = marathonClient.getWinner(); // actual response from the

        assertEquals(oWinner, oResponse);

        verify(restTemplate).getForObject(winnerURL, Runner.class);

    }
}
