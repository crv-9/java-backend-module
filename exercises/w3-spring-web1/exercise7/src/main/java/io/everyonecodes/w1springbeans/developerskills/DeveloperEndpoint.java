package io.everyonecodes.w1springbeans.developerskills;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperEndpoint {

    DeveloperService developerService;
    public DeveloperEndpoint(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> getDevelopers() {
        return developerService.findAll();
    }

    @GetMapping("/{skills}")
    public List<Developer> getDevelopersBySkills(@PathVariable("skills") String skills) {
        return developerService.findBy(skills);
    }
}
