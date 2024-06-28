package io.everyonecodes.w1springbeans.users;

import io.everyonecodes.w1springbeans.users.logic.UserStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    UserStore userStore;

    String url = "/users";

    @Test
    void getUserByEmail(){
        String userEmail = "test@test.com";

        testRestTemplate.getForObject(url + "/" +userEmail, Optional.class);

        verify(userStore).getUserByEmail(userEmail);
    }
}
