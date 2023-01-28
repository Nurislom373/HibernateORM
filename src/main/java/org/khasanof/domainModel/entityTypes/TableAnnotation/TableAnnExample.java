package org.khasanof.domainModel.entityTypes.TableAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/28/2023
 * <br/>
 * Time: 11:12 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.TableAnnotation
 */
@Entity(name = "TableAnnExm")
@Table(
        catalog = "public",
        schema = "table",
        name = "table_ann_exm"
)
public class TableAnnExample {

    @Id
    private Integer id;

    private String title;

    private String author;

    // Getters and setters are omitted for brevity
}
