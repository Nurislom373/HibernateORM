package org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/25/2023
 * <br/>
 * Time: 11:13 PM
 * <br/>
 * Package: org.khasanof.embeddableValues.overridingEmbeddableTypes
 */
@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
}
