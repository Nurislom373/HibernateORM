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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntryPK that = (OrderEntryPK) o;

        if (orderId != that.orderId) return false;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        return result;
    }
}
