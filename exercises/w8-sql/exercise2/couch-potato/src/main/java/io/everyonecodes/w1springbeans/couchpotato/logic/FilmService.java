package io.everyonecodes.w1springbeans.couchpotato.logic;

import io.everyonecodes.w1springbeans.couchpotato.config.FilmRepository;
import io.everyonecodes.w1springbeans.couchpotato.model.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> showAllFilms() {
        return filmRepository.findAll();
    }

    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }
}
