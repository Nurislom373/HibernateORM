package org.khasanof.domainModel.identifiers.primaryKeyJoinColumnAnn;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.NaturalId;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 5:35 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.derivedIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "derived_pk_entity")
public class DerivedPKEntity {

    @Id
    private Long id;

    @NaturalId
    private String registrationNumber;

    // ...
}
