package nl.miwgroningen.ch.eelkemulder.libraryDemo.controller;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Author;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;


    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @GetMapping("/all")
    protected String showAuthorOverview(Model model) {
        model.addAttribute("allAuthors", authorRepository.findAll());
        model.addAttribute("newAuthor", new Author());
        return "authorOverview";
    }

    @PostMapping("/new")
    protected String saveOrUpdateAuthor(@ModelAttribute("newAuthor") Author author, BindingResult result) {
        if (!result.hasErrors()) {
            authorRepository.save(author);
        }

        return "redirect:/authors/all";
    }

}
