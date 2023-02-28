package org.khasanof.domainModel.naturalIds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.NaturalId;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/28/2023
 * <br/>
 * Time: 3:06 PM
 * <br/>
 * Package: org.khasanof.domainModel.naturalIds
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "natural_book")
public class NaturalBook {

    @Id
    private Integer id;
    private String title;
    private String author;
    @NaturalId
    private String isbn;
}
