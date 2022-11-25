package nl.miwgroningen.ch.eelkemulder.libraryDemo.repository;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Long> {
}
