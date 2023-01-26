package org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
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
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NaturalId
    private String name;

    public Country(String name) {
        this.name = name;
    }
}
