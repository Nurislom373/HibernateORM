package org.khasanof.domainModel.collections.elementCollection;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionType;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/15/2023
 * <br/>
 * Time: 9:55 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entity_with_list", schema = "collections")
public class EntityWithList {

    @Id
    @GeneratedValue
    private Integer id;

    @ElementCollection
    private List<SimpleEntity> entities;

}
