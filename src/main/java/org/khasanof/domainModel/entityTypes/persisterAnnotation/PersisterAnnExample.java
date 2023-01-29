package org.khasanof.domainModel.entityTypes.persisterAnnotation;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Persister;
import org.hibernate.persister.entity.EntityPersister;

import java.util.Set;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/29/2023
 * <br/>
 * Time: 7:38 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.persisterAnnotation
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "persister_ann_exm")
@Persister(impl = EntityPersister.class)
public class PersisterAnnExample {

    @Id
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<ETPersisterEntity> sets;

    public void addPersist(ETPersisterEntity entity) {
        this.sets.add(entity);
        entity.setExample(this);
    }
}
