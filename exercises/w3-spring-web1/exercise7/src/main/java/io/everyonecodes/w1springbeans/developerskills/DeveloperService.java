package io.everyonecodes.w1springbeans.developerskills;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {
    List<Developer> developers;

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> findAll() {
        return developers;
    }

    public List<Developer> findBy(String skills) {
        List<String> skillsRequested = List.of(skills.split("\\s"));
        List<Developer> finalDevs = new ArrayList<>();
        // here we return a developer if they have any of the requested skills
//        for (Developer developer : developers) {
//            for (String skill : skillsRequested) {
//                if (developer.getSkills().contains(skill)) {
//                    finalDevs.add(developer);
//                }
//            }
//        }
//        return finalDevs;
        // here we return a developer if they have all requested skills
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(skillsRequested))
                .toList();
    }
}
