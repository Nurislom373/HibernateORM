package org.khasanof.domainModel.identifiers.derivedIdentifiers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/31/2023
 * <br/>
 * Time: 11:13 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.derivedIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "derived_idn_details")
public class DerivedIdnDetails {

    @Id
    private Long id;

    private String nickName;

    @OneToOne
    @MapsId
    private DerivedIdn derivedIdn;
}
