package io.everyonecodes.w1springbeans.advancedtypes;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyEndpoint {
    List<Academy> academies;

    public AcademyEndpoint(AcademyConfiguration academyConfiguration){
        this.academies = academyConfiguration.getAcademies();
    }

    @GetMapping()
    public List<Academy> getAcademies() {
        return academies;
    }
}
