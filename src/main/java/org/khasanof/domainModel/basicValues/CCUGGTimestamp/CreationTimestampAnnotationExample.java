package org.khasanof.domainModel.basicValues.CCUGGTimestamp;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 7:43 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "creation_timestamp_ann_exm")
public class CreationTimestampAnnotationExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "curTimestamp")
    @CreationTimestamp
    private Date timestamp;
}
