package nl.miwgroningen.ch.eelkemulder.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity @Getter @Setter
public class Copy {


    @Id
    @GeneratedValue
    private Long copyId;

    @ManyToOne
    private Book book;

    Boolean available = true;


}
