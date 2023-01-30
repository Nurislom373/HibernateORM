package org.khasanof.domainModel.identifiers.compositeIdentifiers;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/30/2023
 * <br/>
 * Time: 11:25 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.compositeIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_entry")
public class OrderEntry {

    /*
        define an id using @EmbeddedId
     */
    @EmbeddedId
    private OrderEntryPK entryId;

    private String name;

    private String description;

}
