package io.everyonecodes.w1springbeans.users.communication.endpoints;

import io.everyonecodes.w1springbeans.users.logic.UserStore;
import io.everyonecodes.w1springbeans.users.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserEndpoint {

    private final UserStore userStore;

    public UserEndpoint(UserStore userStore) {
        this.userStore = userStore;
    }

    // returning all users - testing purposes
    @GetMapping
    public List<User> getUsers() {
        return userStore.getUsers();
    }

    // returning specific user, if they have an account.
    @GetMapping("/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userStore.getUserByEmail(email);
    }

    // in case I want to post a new user
    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userStore.addUser(user);
    }



}
