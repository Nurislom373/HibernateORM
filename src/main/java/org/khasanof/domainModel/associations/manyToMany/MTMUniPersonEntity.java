package org.khasanof.domainModel.associations.manyToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/5/2023
 * <br/>
 * Time: 11:44 AM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToMany
 */
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mtm_uni_person_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MTMUniPersonEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MTMUniAddressEntity> addresses;

    // ...

}
