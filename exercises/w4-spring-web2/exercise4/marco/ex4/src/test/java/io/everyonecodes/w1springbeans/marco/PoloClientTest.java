package io.everyonecodes.w1springbeans.marco;


import io.everyonecodes.w1springbeans.marco.clients.PoloClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PoloClientTest {

    @Autowired
    private PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate;


    @Test
    void poloClient() {
        String url = "http://localhost:9001/polo/";
        String message = "Marco";
        Mockito.when(restTemplate.postForObject(url,message, String.class)).thenReturn("Polo");
        String response = poloClient.forwardToPolo(message);
        Mockito.verify(restTemplate).postForObject(url,message, String.class);

        assertEquals("Polo", response);
    }



}
