package io.everyonecodes.w1springbeans.advancedtypes.config;

import io.everyonecodes.w1springbeans.advancedtypes.model.Academy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("education")
public class AcademyConfiguration {
    List<Academy> academies;

    public List<Academy> getAcademies() {
        return academies;
    }

    public void setAcademies(List<Academy> academies) {
        this.academies = academies;
    }

}
