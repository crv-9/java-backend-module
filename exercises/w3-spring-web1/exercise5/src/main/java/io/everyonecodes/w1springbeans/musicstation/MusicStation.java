package io.everyonecodes.w1springbeans.musicstation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("music")
public class MusicStation {
    List<Song> songs;

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findAll() {
        return songs;
    }

    public List<Song> findBy(String genre){
        return songs.stream()
                .filter(song -> song.getGenre().equals(genre))
                .toList();
    }
}
