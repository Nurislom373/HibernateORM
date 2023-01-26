package org.khasanof.domainModel.embeddableValues.targetAnnoatation;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Target;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/26/2023
 * <br/>
 * Time: 10:17 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.targetAnnoatation
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "target_ann_exm")
public class TargetAnnExample {

    @Id
    private Integer id;

    private String name;

    @Embedded
    @Target(GPS.class)
    private Coordinates coordinates;
}
