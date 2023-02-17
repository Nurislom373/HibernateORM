package org.khasanof.domainModel.collections.mapCollection.exThrity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 11:02 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection.exSecond
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "map_sec_order", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MapSecOrder {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_item_mapping",
            schema = "collections",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")}
    )
    @MapKey(name = "itemName")
    private Map<String, MapItem> itemMap;
}
