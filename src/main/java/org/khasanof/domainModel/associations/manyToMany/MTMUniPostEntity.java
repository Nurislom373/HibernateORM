package org.khasanof.domainModel.associations.manyToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/7/2023
 * <br/>
 * Time: 3:29 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToMany
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "mtm_uni_post_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MTMUniPostEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<MTMUniTagEntity> tags = new ArrayList<>();

    public MTMUniPostEntity(String title) {
        this.title = title;
    }

    public void addTag(MTMUniTagEntity tag) {
        tags.add(tag);
        tag.getPosts().add(this);
    }

    public void removeTag(MTMUniTagEntity tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MTMUniPostEntity that = (MTMUniPostEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }
}
