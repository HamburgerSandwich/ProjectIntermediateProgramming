package nl.miwgroningen.ch.eelkemulder.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter @Setter
public class Film {
    @Id
    @GeneratedValue
    private Long filmId;

    private String title;
    private int releaseYear;
    private double rating;


}
