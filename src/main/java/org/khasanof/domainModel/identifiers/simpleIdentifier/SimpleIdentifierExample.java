package org.khasanof.domainModel.identifiers.simpleIdentifier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/30/2023
 * <br/>
 * Time: 5:12 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "simple_identifier_exm")
public class SimpleIdentifierExample {

    // Assigned Identifier
    @Id
    private Integer id;

    private String title;

    private String author;

}
