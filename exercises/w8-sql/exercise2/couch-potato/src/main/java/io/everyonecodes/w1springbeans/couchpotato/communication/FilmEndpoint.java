package io.everyonecodes.w1springbeans.couchpotato.communication;

import io.everyonecodes.w1springbeans.couchpotato.logic.FilmService;
import io.everyonecodes.w1springbeans.couchpotato.model.Film;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {

    private final FilmService filmService;

    public FilmEndpoint(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getFilms() {
        return filmService.showAllFilms();
    }

    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        return filmService.addFilm(film);
    }
}
