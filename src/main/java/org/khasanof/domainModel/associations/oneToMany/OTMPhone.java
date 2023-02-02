package org.khasanof.domainModel.associations.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 4:58 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToMany
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "otm_phone")
@Table(name = "otm_phone", schema = "association")
public class OTMPhone {

    @Id
    @GeneratedValue
    private Integer id;

    private String number;

    // ...
}
