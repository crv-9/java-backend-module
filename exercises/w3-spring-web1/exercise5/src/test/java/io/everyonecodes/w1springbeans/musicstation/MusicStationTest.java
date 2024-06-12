package io.everyonecodes.w1springbeans.musicstation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MusicStationTest {
    @Autowired
    MusicStation musicStation;

    @Test
    public void musicStationFindAll() {
        List<Song> result = musicStation.findAll();
        for (Song song : result) {
            System.out.println(song.getName());
        }
    }

    @Test
    public void musicStationFindBy() {
        List<Song> result = musicStation.findBy("Electronic");
        for (Song song : result) {
            System.out.println(song.getName());
        }
    }
}
