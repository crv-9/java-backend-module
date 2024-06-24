package io.everyonecodes.w1springbeans.recommendations;

import io.everyonecodes.w1springbeans.recommendations.clients.HotRightNowClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HotRightNowClientTest {
    @Autowired
    HotRightNowClient hotRightNowClient;

    @MockBean
    RestTemplate restTemplate;

    String url = "http://localhost.9002/movies";

    @Test
    void getHot(){
        System.out.println(hotRightNowClient.getHotRightNowMovies());
    }
}
