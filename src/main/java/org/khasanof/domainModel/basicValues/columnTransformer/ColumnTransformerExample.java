package org.khasanof.domainModel.basicValues.columnTransformer;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 10:17 PM
 * <br/>
 * Package: org.khasanof.basicValues.columnTransformer
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "column_transformer_exm")
public class ColumnTransformerExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "passwd")
    @ColumnTransformer(
            read = "decrypt(passwd, '00', 'aes')",
            write = "encrypt(?, '00', 'aes')"
    )
    private String password;
}
