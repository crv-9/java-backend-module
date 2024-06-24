package io.everyonecodes.w1springbeans.hotrightnow;



import io.everyonecodes.w1springbeans.hotrightnow.logic.MovieStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieStoreTest {

    @Autowired
    MovieStore movieStore;

    @Test
    void getMovies(){
        System.out.println(movieStore.getMovies());
    }
}
