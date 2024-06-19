package io.everyonecodes.w1springbeans.marco;


import io.everyonecodes.w1springbeans.marco.clients.PoloClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PoloClientTest {

    @Autowired
    private PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate;
    String url = "http://localhost:8080/polo/";

//    @Test
//    void poloClient() {
//        Mockito.when(poloClient.forwardToPolo("Marco")).thenReturn("Polo");
//
//        Mockito.verify(restTemplate);
//    }



}
