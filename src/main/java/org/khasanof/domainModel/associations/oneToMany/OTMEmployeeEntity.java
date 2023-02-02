package org.khasanof.domainModel.associations.oneToMany;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 6:30 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToMany
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "otm_employee", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTMEmployeeEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Set<OTMAccountEntity> accounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OTMEmployeeEntity that = (OTMEmployeeEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
    }

    // ...
}
