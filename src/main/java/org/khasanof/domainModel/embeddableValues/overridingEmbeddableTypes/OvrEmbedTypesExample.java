package org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes;

import jakarta.persistence.*;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/25/2023
 * <br/>
 * Time: 11:08 PM
 * <br/>
 * Package: org.khasanof.embeddableValues.overridingEmbeddableTypes
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ovr_embed_types")
@AttributeOverrides({
        @AttributeOverride(
                name = "ebookPublisher.name",
                column = @Column(name = "ebook_pub_name")
        ),
        @AttributeOverride(
                name = "paperBackPublisher.name",
                column = @Column(name = "paper_back_pub_name")
        )
})
@AssociationOverrides({
        @AssociationOverride(
                name = "ebookPublisher.country",
                joinColumns = @JoinColumn(name = "ebook_pub_country_id")
        ),
        @AssociationOverride(
                name = "paperBackPublisher.country",
                joinColumns = @JoinColumn(name = "paper_back_pub_country_id")
        )
})
public class OvrEmbedTypesExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    private Publisher ebookPublisher;

    private Publisher paperBackPublisher;

    public OvrEmbedTypesExample(String title, String author, Publisher ebookPublisher, Publisher paperBackPublisher) {
        this.title = title;
        this.author = author;
        this.ebookPublisher = ebookPublisher;
        this.paperBackPublisher = paperBackPublisher;
    }
}
