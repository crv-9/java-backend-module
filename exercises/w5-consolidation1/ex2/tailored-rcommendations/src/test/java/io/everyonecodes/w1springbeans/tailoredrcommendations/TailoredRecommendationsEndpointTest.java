package io.everyonecodes.w1springbeans.tailoredrcommendations;

import io.everyonecodes.w1springbeans.tailoredrcommendations.logic.TailoredRecommendationsStore;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.Movie;
import io.everyonecodes.w1springbeans.tailoredrcommendations.model.TailoredRecommendation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TailoredRecommendationsEndpointTest {

    // Why using the TestREstTemplate: it is for the clients and for my own I need the copy.
    // my application requires the double of the restTemplate --> TestRestTemplate
    // this is the copy of the RestTemplate
    // used for our own application when it is tested
    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TailoredRecommendationsStore tailoredRecommendationsStore;

    String url = "/tailoredrecommendations";

    // Don't I need an assertion here?
    // No I don't need to do an assertion.
    // if you want to test an actual value, it would be extra. As the logic is being tested before.
    @Test
    void getAllRecommendationsByUserUuid() {
        String userUuid = "123abc";

        testRestTemplate.getForObject(url + "/"+userUuid, Movie[].class);

        verify(tailoredRecommendationsStore).findRecommendationsByUserUuid(userUuid);
    }

    @Test
    void post(){
        TailoredRecommendation tailoredRecommendation = new TailoredRecommendation("knownUserUuid", new Movie("title", "syn"));

        testRestTemplate.postForObject(url, tailoredRecommendation ,TailoredRecommendation.class);

        verify(tailoredRecommendationsStore).addTailoredRecommendation(tailoredRecommendation);
    }




}
