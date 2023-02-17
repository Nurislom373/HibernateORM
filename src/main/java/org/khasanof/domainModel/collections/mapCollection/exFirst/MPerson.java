package org.khasanof.domainModel.collections.mapCollection.exFirst;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 8:48 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_person", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MPerson {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @ElementCollection
    @CollectionTable(name = "phone_register", schema = "collections")
    @Column(name = "since")
    private Map<MPhone, Date> phoneRegister;
}
