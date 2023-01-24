package org.khasanof.basicValues.jdbcTypeCodeAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JavaTypeRegistration;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.descriptor.java.StringJavaType;

import java.sql.Types;
import java.util.BitSet;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 6:52 PM
 * <br/>
 * Package: org.khasanof.basicValues.bitSetClass
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JavaTypeRegistration(javaType = String.class, descriptorClass = StringJavaType.class)
public class JdbcTypeCodeExample {

    @Id
    private Integer id;

    @JdbcTypeCode(Types.VARBINARY)
    private BitSet bitSet;

    @JdbcTypeCode(Types.INTEGER)
    private String num;
}
