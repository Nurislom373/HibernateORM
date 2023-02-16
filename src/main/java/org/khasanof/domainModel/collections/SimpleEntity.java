package org.khasanof.domainModel.collections;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class SimpleEntity {

    private String first;
    private String last;

    public SimpleEntity(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public SimpleEntity() {

    }
}
