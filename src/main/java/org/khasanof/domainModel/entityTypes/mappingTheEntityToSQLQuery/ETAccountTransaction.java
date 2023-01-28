package org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/28/2023
 * <br/>
 * Time: 11:37 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ETAccountTransaction")
@Table(name = "et_account_transaction")
public class ETAccountTransaction {

    @Id
    private Integer id;

    @ManyToOne
    private ETAccount account;

    private Integer cents;

    private String description;
}
