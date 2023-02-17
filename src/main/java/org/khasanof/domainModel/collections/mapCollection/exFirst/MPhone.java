package org.khasanof.domainModel.collections.mapCollection.exFirst;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 8:49 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection
 */
@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class MPhone {

    @Enumerated(EnumType.STRING)
    private MPhoneType type;

    @Column(name = "`number`")
    private String number;
}
