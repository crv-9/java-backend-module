package io.everyonecodes.w1springbeans.marathonintegration.endpoints;

import io.everyonecodes.w1springbeans.marathonintegration.logic.MarathonTester;
import io.everyonecodes.w1springbeans.marathonintegration.model.Runner;
import io.everyonecodes.w1springbeans.marathonintegration.model.TestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon/integration")
public class MarathonIntegrationEndpoint {

    private final MarathonTester marathonTester;

    public MarathonIntegrationEndpoint(MarathonTester marathonTester) {
        this.marathonTester = marathonTester;
    }

//    @GetMapping
//    public String test() {
//        return marathonTester.testList();
//    }

    @GetMapping
    public TestResult testMarathonIntegration() {
        return marathonTester.runCompleteTest();
    }

}
