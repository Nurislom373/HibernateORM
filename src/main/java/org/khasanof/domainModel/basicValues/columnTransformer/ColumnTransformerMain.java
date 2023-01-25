package org.khasanof.domainModel.basicValues.columnTransformer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 10:20 PM
 * <br/>
 * Package: org.khasanof.basicValues.columnTransformer
 */
public class ColumnTransformerMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var columnTransformerExample = new ColumnTransformerExample();
            columnTransformerExample.setPassword("1234");
            session.persist(columnTransformerExample);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
