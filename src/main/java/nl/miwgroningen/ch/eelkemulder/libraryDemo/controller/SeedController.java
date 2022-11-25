package nl.miwgroningen.ch.eelkemulder.libraryDemo.controller;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Author;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Book;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Copy;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.BookRepository;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.CopyRepository;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class SeedController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;
    private final FilmRepository filmRepository;

    public SeedController(AuthorRepository authorRepository,
                          BookRepository bookRepository,
                          CopyRepository copyRepository,
                          FilmRepository filmRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
        this.filmRepository = filmRepository;
    }

    @GetMapping("/seed")
    protected String seedDatabase(){
        Author nietzsche = new Author();
        nietzsche.setFirstName("Fredrich Wilhelm");
        nietzsche.setInfixName("");
        nietzsche.setLastName("Nietzsche");

        Author goethe = new Author();
        goethe.setFirstName("Wilhelm");
        goethe.setInfixName("Von");
        goethe.setLastName("Goethe");

        Author jung = new Author();
        jung.setFirstName("Carl Gustav");
        jung.setInfixName("");
        jung.setLastName("Jung");

        authorRepository.save(nietzsche);
        authorRepository.save(goethe);
        authorRepository.save(jung);

        Set<Author> eccoHomeNietzsche = new HashSet<>();
        eccoHomeNietzsche.add(nietzsche);

        Set<Author> dynamicsOfPsycheJung = new HashSet<>();
        dynamicsOfPsycheJung.add(jung);

        Set<Author> sorrowsGoethe = new HashSet<>();
        sorrowsGoethe.add(nietzsche);


        Book eccoHome = new Book();
        eccoHome.setAuthors(eccoHomeNietzsche);
        eccoHome.setTitle("Ecco Homo");
        eccoHome.setGenre("Filosofie");

        Book dynamics = new Book();
        dynamics.setAuthors(dynamicsOfPsycheJung);
        dynamics.setTitle("The Dynamics of The Psyche");
        dynamics.setGenre("Psychologie");

        Book sorrow = new Book();
        sorrow.setAuthors(sorrowsGoethe);
        sorrow.setTitle("The Sorrows of Young Werther");
        sorrow.setGenre("Literatuur");

        bookRepository.save(eccoHome);
        bookRepository.save(dynamics);
        bookRepository.save(sorrow);

        Copy copyEccoHomo = new Copy();
        copyEccoHomo.setBook(eccoHome);

        Copy copyDynamics = new Copy();
        copyDynamics.setBook(dynamics);

        Copy copySorrow = new Copy();
        copySorrow.setBook(sorrow);

        copyRepository.save(copyEccoHomo);
        copyRepository.save(copyDynamics);
        copyRepository.save(copySorrow);




        return "redirect:/books/all";
    }
}
