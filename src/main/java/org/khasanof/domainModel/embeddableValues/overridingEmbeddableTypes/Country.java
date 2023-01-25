package org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.NaturalId;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/25/2023
 * <br/>
 * Time: 11:12 PM
 * <br/>
 * Package: org.khasanof.embeddableValues.overridingEmbeddableTypes
 */
@Entity(name = "country")
public class Country {

    @Id
    private Integer id;

    @NaturalId
    private String name;
}
