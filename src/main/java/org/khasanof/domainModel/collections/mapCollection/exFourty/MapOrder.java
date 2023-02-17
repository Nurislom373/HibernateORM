package org.khasanof.domainModel.collections.mapCollection.exFourty;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 11:44 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection.exFourty
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "map_order", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MapOrder {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_item_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "seller_id")
    private Map<MapSeller, MapItem> sellerItemMap;
}
