package org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/28/2023
 * <br/>
 * Time: 11:33 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ETClient")
@Table(name = "et_client")
public class ETClient {

    @Id
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
