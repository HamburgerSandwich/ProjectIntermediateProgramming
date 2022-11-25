package nl.miwgroningen.ch.eelkemulder.libraryDemo.repository;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
