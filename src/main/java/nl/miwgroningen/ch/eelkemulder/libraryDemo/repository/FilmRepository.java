package nl.miwgroningen.ch.eelkemulder.libraryDemo.repository;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
