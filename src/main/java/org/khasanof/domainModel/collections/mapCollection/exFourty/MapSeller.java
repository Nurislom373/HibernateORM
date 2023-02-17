package org.khasanof.domainModel.collections.mapCollection.exFourty;

import jakarta.persistence.*;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 11:41 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection.exFourty
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MapSeller {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String sellerName;
}
