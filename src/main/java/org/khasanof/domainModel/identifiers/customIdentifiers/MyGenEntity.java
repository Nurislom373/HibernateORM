package org.khasanof.domainModel.identifiers.customIdentifiers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/31/2023
 * <br/>
 * Time: 7:33 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.customIdentifiers
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "my_gen")
public class MyGenEntity {

    @Id
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @Parameter(name = "prefix", value = "prod"),
            strategy = "org.khasanof.domainModel.identifiers.customIdentifiers.MyGenerator"
    )
    private String prodId;

    private String name;

    public MyGenEntity(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyGenEntity that = (MyGenEntity) o;

        if (!Objects.equals(prodId, that.prodId)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = prodId != null ? prodId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
