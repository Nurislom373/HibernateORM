package org.khasanof.domainModel.associations.oneToMany;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 6:33 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToMany
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "otm_account_entity", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTMAccountEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    private String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OTMAccountEntity that = (OTMAccountEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    // ...
}
