package org.khasanof.domainModel.basicValues.CCUGGTimestamp;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 9:05 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "generated_ann_exm")
public class GeneratedAnnotationExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
//    @Generated(GenerationTime.ALWAYS)
//    @Column(columnDefinition = "as concat( firstName + lastName )")
    private String fullName;

    public GeneratedAnnotationExample(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
