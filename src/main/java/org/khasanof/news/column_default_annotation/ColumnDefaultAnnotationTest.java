package org.khasanof.news.column_default_annotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

/**
 * @author Nurislom
 * @see org.khasanof.news.column_default_annotation
 * @since 10/2/2023 11:51 AM
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Person {

    @Id
    private Long id;

    @ColumnDefault("'N/A'")
    private String name;

    @ColumnDefault("-1")
    private Long clientId;

}
