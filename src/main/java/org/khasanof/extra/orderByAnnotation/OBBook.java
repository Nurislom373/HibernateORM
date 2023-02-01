package org.khasanof.extra.orderByAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 7:42 PM
 * <br/>
 * Package: org.khasanof.extra.orderByAnnotation
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ob_book")
public class OBBook {

    @Id
    private Integer id;

    private String name;
}
