package org.khasanof.domainModel.collections.listArrayType;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 5:28 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.listArrayType
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Event")
@Table(name = "event", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Type(value = ListArrayType.class)
    @Column(
            name = "sensor_ids",
            columnDefinition = "uuid[]"
    )
    private List<UUID> sensorIds;

    @Type(ListArrayType.class)
    @Column(
            name = "sensor_names",
            columnDefinition = "text[]"
    )
    private List<String> sensorNames;

    @Type(ListArrayType.class)
    @Column(
            name = "sensor_values",
            columnDefinition = "integer[]"
    )
    private List<Integer> sensorValues;

    @Type(value = ListArrayType.class)
    @Column(
            name = "sensor_long_values",
            columnDefinition = "bigint[]"
    )
    private List<Long> sensorLongValues;

    @Type(ListArrayType.class)
    @Column(
            name = "date_values",
            columnDefinition = "date[]"
    )
    private List<Date> dateValues;

    @Type(ListArrayType.class)
    @Column(
            name = "timestamp_values",
            columnDefinition = "timestamp[]"
    )
    private List<Date> timestampValues;
}
