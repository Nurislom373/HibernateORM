package org.khasanof.domainModel.associations.oneToOne;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 7:10 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToOne
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oto_phone_details_entity", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTOUniPhoneDetailsEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "technology", nullable = false)
    private String technology;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OTOUniPhoneDetailsEntity that = (OTOUniPhoneDetailsEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(provider, that.provider)) return false;
        return Objects.equals(technology, that.technology);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (technology != null ? technology.hashCode() : 0);
        return result;
    }

    // ...
}
