package org.khasanof.domainModel.associations.manyToMany;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/7/2023
 * <br/>
 * Time: 3:31 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToMany
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mtm_uni_tag_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MTMUniTagEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @NaturalId
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<MTMUniPostEntity> posts = new ArrayList<>();

    public MTMUniTagEntity(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MTMUniTagEntity that = (MTMUniTagEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (posts != null ? posts.hashCode() : 0);
        return result;
    }
}
