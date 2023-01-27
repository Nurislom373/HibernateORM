package org.khasanof.domainModel.embeddableValues.customInstaniation;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.EmbeddableInstantiator;

import java.util.Set;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 10:41 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.customInstaniation
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "custom_ins_exm")
public class CustomInstantiationExample {

    @Id
    private Integer id;

    @Embedded
    @EmbeddableInstantiator(NameInstantiator.class)
    private Name name;

}
