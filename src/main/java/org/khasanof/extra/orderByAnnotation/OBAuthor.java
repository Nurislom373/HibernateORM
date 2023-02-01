package org.khasanof.extra.orderByAnnotation;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 7:41 PM
 * <br/>
 * Package: org.khasanof.extra.orderByAnnotation
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ob_author")
public class OBAuthor {

    @Id
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(name = "ob_book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    @OrderBy(value = "name ASC")
    private List<OBBook> books;
}
