package io.everyonecodes.w1springbeans.basket.communication.clients;

import io.everyonecodes.w1springbeans.basket.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class UsersClient {
    private final RestTemplate restTemplate;
    private final String clientUrl;

    public UsersClient(RestTemplate restTemplate, @Value("${client.url}") String clientUrl) {
        this.restTemplate = restTemplate;
        this.clientUrl = clientUrl;
    }

    // working as expected
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(restTemplate.getForObject(clientUrl + "/" + email, User.class));
    }

}
