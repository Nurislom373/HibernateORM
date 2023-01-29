package org.khasanof.domainModel.entityTypes.persisterAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Persister;
import org.hibernate.persister.entity.EntityPersister;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/29/2023
 * <br/>
 * Time: 7:39 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.persisterAnnotation
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "et_persister_entity")
@Persister(impl = EntityPersister.class)
public class ETPersisterEntity {

    @Id
    private Integer id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersisterAnnExample example;
}
