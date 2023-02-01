package org.khasanof.domainModel.associations.manyToOneAnnotation;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 8:43 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToOneAnn
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mto_phone", schema = "association")
public class MTOPhone {

    @Id
    @GeneratedValue
    private Integer id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id",
            foreignKey = @ForeignKey(name = "PERSON_ID_FK")
    )
    private MTOPerson person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MTOPhone mtoPhone = (MTOPhone) o;

        if (!Objects.equals(id, mtoPhone.id)) return false;
        if (!Objects.equals(number, mtoPhone.number)) return false;
        return Objects.equals(person, mtoPhone.person);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    // ...
}
