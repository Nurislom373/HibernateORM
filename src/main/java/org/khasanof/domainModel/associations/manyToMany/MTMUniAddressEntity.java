package org.khasanof.domainModel.associations.manyToMany;

import jakarta.persistence.*;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/5/2023
 * <br/>
 * Time: 11:45 AM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToMany
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mtm_uni_address_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MTMUniAddressEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String street;

    @Column(name = "`number`")
    private String number;

    public MTMUniAddressEntity(String street, String number) {
        this.street = street;
        this.number = number;
    }

    // ...
}
