package io.everyonecodes.w1springbeans.advancedtypes.Academy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyEndpoint {

    private final List<Academy> academies;

    public AcademyEndpoint(@Value("${education.academies}") List<Academy> academies) {
        this.academies = academies;
    }

    @GetMapping
    public List<Academy> getAcademies() {
        return academies;
    }
}
