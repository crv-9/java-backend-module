package io.everyonecodes.w1springbeans.advancedtypes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
