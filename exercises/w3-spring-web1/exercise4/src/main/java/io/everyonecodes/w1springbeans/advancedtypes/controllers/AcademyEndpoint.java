package io.everyonecodes.w1springbeans.advancedtypes.controllers;

import io.everyonecodes.w1springbeans.advancedtypes.config.AcademyConfiguration;
import io.everyonecodes.w1springbeans.advancedtypes.model.Academy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyEndpoint {
    List<Academy> academies;

    // this is needed as the bean was not created in config
    public AcademyEndpoint(AcademyConfiguration academyConfiguration){
        this.academies = academyConfiguration.getAcademies();
    }

    @GetMapping()
    public List<Academy> getAcademies() {
        return academies;
    }
}
