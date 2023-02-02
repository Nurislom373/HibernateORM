package org.khasanof.domainModel.associations.oneToOne;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 7:40 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToOne
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oto_bid_phone_details_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTOBidPhoneDetailsEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    private String provider;
    private String technology;

    @OneToOne
    @JoinColumn(name = "phone_id")
    private OTOBidPhoneEntity phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OTOBidPhoneDetailsEntity that = (OTOBidPhoneDetailsEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(provider, that.provider)) return false;
        if (!Objects.equals(technology, that.technology)) return false;
        return Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (technology != null ? technology.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OTOBidPhoneDetailsEntity{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                ", technology='" + technology + '\'' +
                ", phone=" + phone +
                '}';
    }
}
