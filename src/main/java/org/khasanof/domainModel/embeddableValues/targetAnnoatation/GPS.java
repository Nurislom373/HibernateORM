package org.khasanof.domainModel.embeddableValues.targetAnnoatation;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/26/2023
 * <br/>
 * Time: 10:18 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.targetAnnoatation
 */
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@ToString
public class GPS implements Coordinates {

    private double latitude;
    private double longitude;

    @Override
    public double x() {
        return latitude;
    }

    @Override
    public double y() {
        return longitude;
    }
}
