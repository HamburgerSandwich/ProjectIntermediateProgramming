package nl.miwgroningen.ch.eelkemulder.libraryDemo.controller;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Book;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Copy;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.BookRepository;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/copy")
public class CopyController {
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    public CopyController(BookRepository bookRepository, CopyRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }

    @GetMapping("/new/{bookId}")
    protected String createNewCopy(@PathVariable("bookId") Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);

        if(book.isPresent()){
            Copy copy = new Copy();
            copy.setBook(book.get());
            copyRepository.save(copy);

        }

        return"redirect:/books/all";
    }

    @GetMapping("/borrow/{copyId}")
    protected String makeCopyUnavailable(@PathVariable("copyId") Long copyId) {
        Optional<Copy> copy = copyRepository.findById(copyId);

        if (copy.isPresent() && copy.get().getAvailable()) {
            copy.get().setAvailable(false);
            copyRepository.save(copy.get());
            return "redirect:/books/details/" + copy.get().getBook().getTitle();
        }

        return "redirect:/books/all";
    }

    @GetMapping("/return/{copyId}")
    protected String makeCopyAvailable(@PathVariable("copyId") Long copyId) {
        Optional<Copy> copy = copyRepository.findById(copyId);

        if (copy.isPresent() && !copy.get().getAvailable()) {
            copy.get().setAvailable(true);
            copyRepository.save(copy.get());
            return "redirect:/books/details/" + copy.get().getBook().getTitle();
        }

        return "redirect:/books/all";
    }

}
