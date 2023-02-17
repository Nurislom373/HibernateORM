package org.khasanof.domainModel.collections.mapCollection.exSecond;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 10:36 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection.second
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
    private Integer id;

    @ElementCollection
    @CollectionTable(
            name = "item_price_mapping",
            schema = "collections",
            joinColumns = {
                    @JoinColumn(name = "order_id", referencedColumnName = "id")
            }
    )
    @MapKeyJoinColumn(name = "item_name")
    @Column(name = "price")
    private Map<String, Double> itemPriceMap;
}
