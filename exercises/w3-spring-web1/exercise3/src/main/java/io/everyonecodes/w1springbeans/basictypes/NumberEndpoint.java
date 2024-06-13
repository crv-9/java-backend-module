package io.everyonecodes.w1springbeans.basictypes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberEndpoint {
    @GetMapping
    public int getNumber() {
        return 42;
    }
}
