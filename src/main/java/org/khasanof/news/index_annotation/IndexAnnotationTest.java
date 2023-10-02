package org.khasanof.news.index_annotation;

import jakarta.persistence.*;

/**
 * @author Nurislom
 * @see org.khasanof.news.index_annotation
 * @since 10/2/2023 11:54 AM
 */
@Entity
@Table(
        name = "author",
        indexes =  @Index(
                name = "idx_author_first_last_name",
                columnList = "first_name, last_name",
                unique = false
        )
)
public class IndexAnnotationTest {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
