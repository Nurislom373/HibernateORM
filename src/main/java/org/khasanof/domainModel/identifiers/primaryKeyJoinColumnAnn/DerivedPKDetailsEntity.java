package org.khasanof.domainModel.identifiers.primaryKeyJoinColumnAnn;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 5:36 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.derivedIdentifiers
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "derived_pk_details_entity")
public class DerivedPKDetailsEntity {

    @Id
    private Long id;

    private String nickName;

    /*
        The @PrimaryKeyJoinColumn specifies the mapping of the
         foreign key column of a secondary table or the foreign key
         column in an inheritance mapping that uses the JOINED strategy.
         So, the annotation you need to use depends on the context in which
         you want to customize the mapping of the foreign key column.
     */
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    private DerivedPKEntity derivedPK;

    public void setDerivedPK(DerivedPKEntity entity) {
        this.derivedPK = entity;
        this.id = entity.getId();
    }

    // ...
}
