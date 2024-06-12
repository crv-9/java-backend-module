package io.everyonecodes.w1springbeans.developerskills;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DeveloperServiceTest {
    @Autowired
    private DeveloperService developerService;

    @Test
    public void findAll() {
        List<Developer> developers = developerService.findAll();
        for (Developer developer : developers) {
            System.out.println(developer.getName() + " -> skills: " + developer.getSkills());
        }
    }

    @Test
    public void findBySkills() {
        List<Developer> developers = developerService.findBy("Javascript Python");
        for (Developer developer : developers) {
            System.out.println(developer.getName());
        }
    }
}
