package org.khasanof.domainModel.embeddableValues.componentEmbedded;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Target;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/25/2023
 * <br/>
 * Time: 9:55 PM
 * <br/>
 * Package: org.khasanof.embeddableValues.componentEmbedded
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "component_embedded_exm")
public class ComponentEmbeddedExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private Publisher publisher;

    public ComponentEmbeddedExample(String title, Publisher publisher) {
        this.title = title;
        this.publisher = publisher;
    }
}
