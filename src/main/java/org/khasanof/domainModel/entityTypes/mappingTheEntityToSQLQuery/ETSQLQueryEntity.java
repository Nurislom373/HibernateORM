package org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/28/2023
 * <br/>
 * Time: 11:29 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EtSQLQueryEntity")
@Subselect(
        "select a.id as id, concat(concat(c.first_name, ' '), c.last_name) as clientName, sum(atr.cents) as balance " +
                "from et_account a " +
                "join et_client c on c.id = a.client_id " +
                "join et_account_transaction atr on a.id = atr.account_id " +
                "group by a.id, concat(concat(c.first_name, ' '), c.last_name) "
)
@Synchronize({"et_client", "et_account", "et_account_transaction"})
public class ETSQLQueryEntity {

    @Id
    private Integer id;

    private String clientName;

    private int balance;
}
