package io.everyonecodes.w1springbeans.users.logic;

import io.everyonecodes.w1springbeans.users.model.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties("store")
public class UserStore {

    private List<User> users = new ArrayList<>();

    // method to get all users - if needed
    public List<User> getUsers() {
        return users;
    }


    // returning specific user, if they have an account.
    // could be improved by ignoring upperCase - not in the intended scope
    public Optional<User> getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail()
                        .equals(email))
                        .findFirst();
    }

    // adding a user
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
