package io.everyonecodes.w1springbeans.users;

import io.everyonecodes.w1springbeans.users.logic.UserStore;
import io.everyonecodes.w1springbeans.users.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserStoreTest {

    @Autowired
    private UserStore userStore;

    User user1 = new User("user1", "user1@email.com", "standard account");

    @Test
    public void testGetUserByEmail() {
        userStore.addUser(user1);
        String email = user1.getEmail();

        Optional<User> result = userStore.getUserByEmail(email);

        User expectedUser = user1;

        assertTrue(result.isPresent());
        assertEquals(expectedUser, result.get());

    }
}
