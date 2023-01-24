package org.khasanof.basicValues.CCUGGTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.tuple.GenerationTiming;

import java.time.Instant;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 7:26 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CurrentTimestampAnnotationExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CurrentTimestamp(timing = GenerationTiming.INSERT)
    private Instant createdAt;

    @CurrentTimestamp(timing = GenerationTiming.ALWAYS)
    private Instant lastUpdatedAt;
}
