package org.khasanof.domainModel.embeddableValues.parentAnnotation;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Parent;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 10:17 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.parentAnnotation
 */
@Embeddable
public class Coordinates {

    private double latitude;
    private double longitude;

    @Parent
    private ParentAnnExample example;

}
