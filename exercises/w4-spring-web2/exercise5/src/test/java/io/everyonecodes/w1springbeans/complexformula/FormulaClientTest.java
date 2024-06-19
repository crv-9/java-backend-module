package io.everyonecodes.w1springbeans.complexformula;

import io.everyonecodes.w1springbeans.complexformula.clients.FormulaClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FormulaClientTest {

    @Autowired
    private FormulaClient formulaClient;

    @MockBean
    RestTemplate restTemplate;

    @Test
    void formulaClient() {
        Mockito.when(formulaClient.sendAndCalculateNumber("3")).thenReturn(6);

        System.out.println( formulaClient.sendAndCalculateNumber("3"));

//        assertEquals(6,result);

        Mockito.verify(restTemplate);

    }
}
