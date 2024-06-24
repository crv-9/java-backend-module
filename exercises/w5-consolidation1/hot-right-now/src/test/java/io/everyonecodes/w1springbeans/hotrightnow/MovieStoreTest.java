package io.everyonecodes.w1springbeans.hotrightnow;


import io.everyonecodes.w1springbeans.hotrightnow.logic.MovieStore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class MovieStoreTest {
    MovieStore movieStore;

    @Test
    void getMovies(){
        System.out.println(movieStore.getMovies());
    }
}
