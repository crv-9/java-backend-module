package io.everyonecodes.w1springbeans.basket.communication.endpoints;

import io.everyonecodes.w1springbeans.basket.communication.clients.UsersClient;
import io.everyonecodes.w1springbeans.basket.logic.Basket;
import io.everyonecodes.w1springbeans.basket.model.Summary;
import io.everyonecodes.w1springbeans.basket.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/summaries")
public class SummaryEndpoint {

    private final Basket basket;

    public SummaryEndpoint(Basket basket) {
        this.basket = basket;
    }

    @GetMapping
    public List<Summary> getSummaries() {
        return basket.getSummaries();
    }
}
