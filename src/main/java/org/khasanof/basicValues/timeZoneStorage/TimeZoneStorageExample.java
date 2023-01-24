package org.khasanof.basicValues.timeZoneStorage;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.TimeZoneColumn;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.BitSet;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 6:26 PM
 * <br/>
 * Package: org.khasanof.basicValues.timeZoneStorage
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TimeZoneStorageExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "birthday_offset_offset")
    @Column(name = "birthday_offset")
    private OffsetDateTime offsetDateTimeColumn;

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "birthday_zoned_offset")
    @Column(name = "birthday_zoned")
    private ZonedDateTime zonedDateTimeColumn;
}
