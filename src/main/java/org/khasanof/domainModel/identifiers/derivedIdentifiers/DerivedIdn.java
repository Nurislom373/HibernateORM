package org.khasanof.domainModel.identifiers.derivedIdentifiers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.NaturalId;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/31/2023
 * <br/>
 * Time: 11:11 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.derivedIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "derived_idn")
public class DerivedIdn {

    @Id
    private Long id;

    @NaturalId
    private String registrationNumber;

    public DerivedIdn(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
