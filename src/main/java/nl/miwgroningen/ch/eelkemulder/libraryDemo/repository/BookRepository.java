package nl.miwgroningen.ch.eelkemulder.libraryDemo.repository;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

}