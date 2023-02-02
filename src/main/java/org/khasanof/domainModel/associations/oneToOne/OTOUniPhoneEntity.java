package org.khasanof.domainModel.associations.oneToOne;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 7:08 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToOne
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oto_phone_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTOUniPhoneEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    public Integer id;

    @Column(name = "number", nullable = false, updatable = false)
    private String number;

    @OneToOne
    @JoinColumn(name = "details_id")
    private OTOUniPhoneDetailsEntity details;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OTOUniPhoneEntity that = (OTOUniPhoneEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(number, that.number)) return false;
        return Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    // ...

}
