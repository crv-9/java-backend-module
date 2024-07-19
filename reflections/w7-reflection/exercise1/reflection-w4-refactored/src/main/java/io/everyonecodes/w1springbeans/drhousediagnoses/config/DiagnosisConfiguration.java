package io.everyonecodes.w1springbeans.drhousediagnoses.config;

import io.everyonecodes.w1springbeans.drhousediagnoses.model.Diagnosis;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("drhouse")
public class DiagnosisConfiguration {

    private List<Diagnosis> diagnoses;

    @Bean
    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

}
