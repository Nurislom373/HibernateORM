package org.khasanof.domainModel.basicValues.CCUGGTimestamp;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 8:04 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "update_timestamp_ann_exm")
public class UpdateTimestampAnnotationExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Date updatedOn;

    @Column(name = "updated_by")
    private String updatedBy;
}
