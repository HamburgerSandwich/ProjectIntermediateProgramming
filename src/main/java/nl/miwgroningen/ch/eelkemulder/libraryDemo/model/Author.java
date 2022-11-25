package nl.miwgroningen.ch.eelkemulder.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue
    private Long authorId;

    private String firstName;
    private String infixName;
    private String lastName;

    public String getDisplayName() {
        String displayName = firstName;

        if (!infixName.equals("")) {
            displayName += " " + infixName;
        }

        return displayName + " " + lastName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}

