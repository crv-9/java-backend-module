package io.everyonecodes.w1springbeans.musicstation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class MusicStationEndpoint {

    MusicStation musicStation;

    public MusicStationEndpoint(MusicStation musicStation) {
        this.musicStation = musicStation;
    }

    @GetMapping
    List<Song> getSongs() {
        return musicStation.findAll();
    }

    @GetMapping("/{genre}")
    List<Song> getSongsByGenre(@PathVariable String genre) {
        return musicStation.findBy(genre);
    }

}
