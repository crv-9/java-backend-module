package io.everyonecodes.w1springbeans.basket;

import io.everyonecodes.w1springbeans.basket.communication.clients.UsersClient;
import io.everyonecodes.w1springbeans.basket.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UsersClientTest {
    @Autowired
    UsersClient usersClient;

    @MockBean
    RestTemplate restTemplate;

    String url = "http://localhost:9001/users/test@email.com";

    @Test
    void getUser(){
        when(restTemplate.getForObject(url, User.class)).thenReturn(new User());

        usersClient.getUserByEmail("test@email.com");

        verify(restTemplate).getForObject(url, User.class);
    }
}
