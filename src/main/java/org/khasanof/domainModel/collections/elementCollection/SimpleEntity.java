package org.khasanof.domainModel.collections.elementCollection;

import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/15/2023
 * <br/>
 * Time: 9:56 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections
 */
@Getter
@Setter
@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEntity {
    private String first;
    private String last;
}
