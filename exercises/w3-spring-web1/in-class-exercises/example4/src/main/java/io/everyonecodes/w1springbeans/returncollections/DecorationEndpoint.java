package io.everyonecodes.w1springbeans.returncollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/decorations")
public class DecorationEndpoint {

    private final List<Decoration> decorations = List.of(
            new Decoration("plant", 7.75),
            new Decoration("lamp", 12.95)
    );

    @GetMapping()
    public List<Decoration> getDecorations() {
        return decorations;
    }


}
