package org.khasanof.domainModel.basicValues.CCUGGTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.tuple.GenerationTiming;

import java.util.UUID;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 9:14 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "custom_generated_ann_exm")
public class CustomGeneratedAnnotationExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedUuidValue(timing = GenerationTiming.INSERT)
    private UUID createdUuid;

    @GeneratedUuidValue(timing = GenerationTiming.ALWAYS)
    private UUID updatedUuid;
}
