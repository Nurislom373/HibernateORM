package org.khasanof.domainModel.embeddableValues.parentAnnotation;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 10:18 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.parentAnnotation
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "parent_ann_exm")
public class ParentAnnExample {

    @Id
    private Integer id;

    private String name;

    @Embedded
    private Coordinates coordinates;

}
