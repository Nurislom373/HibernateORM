package org.khasanof.domainModel.associations.oneToOne;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 7:37 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToOne
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oto_bid_phone_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTOBidPhoneEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "number")
    private String number;

    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private OTOBidPhoneDetailsEntity details;

    public void addDetails(OTOBidPhoneDetailsEntity entity) {
        entity.setPhone(this);
        this.details = entity;
    }

    public void remove() {
        if (details != null) {
            details.setPhone(null);
            this.details = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OTOBidPhoneEntity that = (OTOBidPhoneEntity) o;

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

    @Override
    public String toString() {
        return "OTOBidPhoneEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", details=" + details +
                '}';
    }
}
