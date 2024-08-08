package io.everyonecodes.w1springbeans.mysterioussecretorder.endpoints;

import io.everyonecodes.w1springbeans.mysterioussecretorder.logic.OrderService;
import io.everyonecodes.w1springbeans.mysterioussecretorder.model.Member;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OrderEndpoint {

    private final OrderService orderService;

    public OrderEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    public String order() {
        return "Mysterious Secret Order";
    }

    @PostMapping
    @Secured("ROLE_MASTER")
    public Member addMember(@RequestBody Member member) {
        return orderService.createMember(member);
    }

    @GetMapping("/members")
    @Secured("ROLE_MASTER")
    public List<Member> getAllMembers() {
        return orderService.getAllSavedMembers();
    }

    @GetMapping("/members/apprentices")
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    public List<Member> getAllApprentices() {
        return orderService.getAllApprentices();
    }
}
