package org.khasanof.domainModel.identifiers.compositeIdentifiers;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/30/2023
 * <br/>
 * Time: 11:15 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.compositeIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderEntryPK implements Serializable {

    private long orderId;
    private long productId;


}
