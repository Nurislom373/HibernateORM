package org.khasanof.domainModel.embeddableValues.customInstaniation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 10:34 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.customInstaniation
 */
@Getter
@Setter
@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Name {

    @Column(name = "first_name")
    private String first;
    @Column(name = "last_name")
    private String last;

}
