package io.everyonecodes.w1springbeans.advancedtypes.Academy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
@ConfigurationProperties("education.academies")
public class AcademyConfiguration {
    private List<Academy> academies;

    public List<Academy> getAcademies() {
        return academies;
    }

    public void setAcademies(List<Academy> academies) {
        this.academies = academies;
    }
}
