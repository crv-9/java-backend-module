package io.everyonecodes.w1springbeans.basket;

import io.everyonecodes.w1springbeans.basket.logic.Basket;
import io.everyonecodes.w1springbeans.basket.model.ItemSelection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemSelectionEndpointTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    Basket basket;

    String url = "/itemselections";
    ItemSelection itemSelection = new ItemSelection("test@email.com", "testItem", 5.0);

    @Test
    void testPostItemSelection() {
        testRestTemplate.postForObject(url, itemSelection, ItemSelection.class);

        verify(basket).addItemSelection(itemSelection);
    }

}
