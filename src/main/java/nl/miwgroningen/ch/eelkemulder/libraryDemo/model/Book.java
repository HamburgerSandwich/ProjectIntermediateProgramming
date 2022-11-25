package nl.miwgroningen.ch.eelkemulder.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity @Getter @Setter
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    private String title;
    private String author;
    private String genre;

    @ManyToMany
    private Set<Author> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }

        return count;
    }

    public String getAuthorsDisplayString() {
        StringBuilder builder = new StringBuilder();

        for (Author author : authors) {
            builder.append(author).append(", ");
        }

        return builder.toString();
    }
}