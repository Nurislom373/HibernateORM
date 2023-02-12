package org.khasanof.domainModel.associations.notFoundAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/12/2023
 * <br/>
 * Time: 9:35 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.notFoundAnnotation
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "NFCityEntity")
@Table(name = "NFCityEntity", schema = "association")
public class NFCityEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public NFCityEntity(String name) {
        this.name = name;
    }
}
