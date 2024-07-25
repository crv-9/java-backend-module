package io.everyonecodes.w1springbeans.couchpotato.config;

import io.everyonecodes.w1springbeans.couchpotato.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
