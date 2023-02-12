package org.khasanof.domainModel.associations.notFoundAnnotation;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.NonFinal;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/12/2023
 * <br/>
 * Time: 9:34 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.notFoundAnnotation
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "NFPersonEntity")
@Table(name = "NFPersonEntity", schema = "association")
public class NFPersonEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @NotFound(action = NotFoundAction.EXCEPTION)
    @JoinColumn(name = "city_fk", referencedColumnName = "id")
    private NFCityEntity city;

    public NFPersonEntity(String name, NFCityEntity city) {
        this.name = name;
        this.city = city;
    }
}
