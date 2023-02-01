package org.khasanof.domainModel.associations.manyToOneAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 8:41 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToOneAnn
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mto_person", schema = "association")
public class MTOPerson {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MTOPerson mtoPerson = (MTOPerson) o;

        if (!Objects.equals(id, mtoPerson.id)) return false;
        return Objects.equals(name, mtoPerson.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    // ...
}
