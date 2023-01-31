package org.khasanof.domainModel.identifiers.compositeIdentifiers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/31/2023
 * <br/>
 * Time: 6:57 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.compositeIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ci_author")
public class CIAuthor implements Serializable {

    @Id
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CIAuthor ciAuthor = (CIAuthor) o;

        return Objects.equals(name, ciAuthor.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
