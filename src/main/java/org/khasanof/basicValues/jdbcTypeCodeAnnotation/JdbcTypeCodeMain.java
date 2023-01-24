package org.khasanof.basicValues.jdbcTypeCodeAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.BitSet;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 7:05 PM
 * <br/>
 * Package: org.khasanof.basicValues.jdbcTypeCodeAnnotation
 */
public class JdbcTypeCodeMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var jdbcType = new JdbcTypeCodeExample(1, new BitSet(2186), "7532");
            session.persist(jdbcType);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
