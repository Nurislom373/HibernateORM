package org.khasanof.domainModel.identifiers.compositeIdentifiers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/30/2023
 * <br/>
 * Time: 11:39 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.compositeIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(OrderEntryPK.class)
public class OrderEntryIdClass {

    @Id
    private long orderId;

    @Id
    private long productId;

    //...
}
