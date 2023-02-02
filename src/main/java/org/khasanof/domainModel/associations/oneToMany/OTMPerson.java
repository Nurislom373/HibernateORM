package org.khasanof.domainModel.associations.oneToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 4:57 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToMany
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "otm_person")
@Table(name = "otm_person", schema = "association")
public class OTMPerson {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OTMPhone> phones;

    // ...
}
