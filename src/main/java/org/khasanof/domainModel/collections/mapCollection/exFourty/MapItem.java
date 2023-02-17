package org.khasanof.domainModel.collections.mapCollection.exFourty;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 11:42 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection.exFourty
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "map_item", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MapItem {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String itemName;

    @Column(name = "price")
    private double itemPrice;

    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private MapItemType itemType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private MapSeller seller;
}
