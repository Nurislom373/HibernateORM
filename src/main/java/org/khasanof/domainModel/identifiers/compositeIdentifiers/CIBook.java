package org.khasanof.domainModel.identifiers.compositeIdentifiers;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.khasanof.domainModel.basicValues.formulaAnnotation.Author;
import org.khasanof.domainModel.embeddableValues.componentEmbedded.Publisher;

import java.io.Serializable;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/31/2023
 * <br/>
 * Time: 6:49 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.compositeIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ci_book")
public class CIBook implements Serializable {

    @Id
    private String title;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private CIAuthor author;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private CIPublisher publisher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CIBook ciBook = (CIBook) o;

        if (!Objects.equals(title, ciBook.title)) return false;
        if (!Objects.equals(author, ciBook.author)) return false;
        return Objects.equals(publisher, ciBook.publisher);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        return result;
    }
}
