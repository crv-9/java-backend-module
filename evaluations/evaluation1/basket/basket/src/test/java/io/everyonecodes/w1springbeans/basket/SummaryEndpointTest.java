package io.everyonecodes.w1springbeans.basket;

import io.everyonecodes.w1springbeans.basket.communication.endpoints.SummaryEndpoint;
import io.everyonecodes.w1springbeans.basket.logic.Basket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SummaryEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Basket basket;

    String url = "/summaries";

    @Test
    void getSummaries() {
        testRestTemplate.getForObject(url, List.class);

        verify(basket).getSummaries();
    }

}
