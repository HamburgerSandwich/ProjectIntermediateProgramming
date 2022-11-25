package nl.miwgroningen.ch.eelkemulder.libraryDemo.controller;

import nl.miwgroningen.ch.eelkemulder.libraryDemo.model.Film;
import nl.miwgroningen.ch.eelkemulder.libraryDemo.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping({"/films/all", "/"})
    protected String showFilmOverview(Model model) {
        model.addAttribute("allFilms", filmRepository.findAll());

        return "filmOverview";
    }

    @GetMapping("/films/new")
    protected String showNewFilmForm(Model model) {
        model.addAttribute("film", new Film());
        return "filmForm";
    }

    @GetMapping("/films/edit/{filmId}")
    protected String showEditFilmForm(@PathVariable("filmId") Long filmId, Model model) {
        Optional<Film> film = filmRepository.findById(filmId);

        if (film.isPresent()) {
            model.addAttribute("film", film.get());
            return "filmForm";
        }

        return "redirect:/films/all";
    }

    @PostMapping("/films/new")
    protected String saveFilm(@ModelAttribute("film") Film filmToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            filmRepository.save(filmToBeSaved);
        }
        return "redirect:/films/all";
    }

    @GetMapping("/films/delete/{filmId}")
    protected String deleteFilm(@PathVariable("filmId") Long filmId) {
        Optional<Film> film = filmRepository.findById(filmId);

        if (film.isPresent()) {
            filmRepository.delete(film.get());
        }

        return "redirect:/films/all";
    }


}
