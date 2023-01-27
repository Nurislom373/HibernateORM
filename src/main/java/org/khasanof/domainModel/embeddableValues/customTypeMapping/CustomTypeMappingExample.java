package org.khasanof.domainModel.embeddableValues.customTypeMapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CompositeType;

import java.util.Set;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 10:46 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.customTypeMapping
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "custom_type_mapping_exm")
public class CustomTypeMappingExample {

    @Id
    private Integer id;

    @Embedded
    @AttributeOverride(name = "firstName", column = @Column(name = "first_name"))
    @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    @CompositeType(CustomNameCompositeType.class)
    private CustomName name;

}
