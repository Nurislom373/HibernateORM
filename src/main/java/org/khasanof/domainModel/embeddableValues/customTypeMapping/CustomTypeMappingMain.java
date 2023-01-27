package org.khasanof.domainModel.embeddableValues.customTypeMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 11:00 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.customTypeMapping
 */
public class CustomTypeMappingMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            get(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void save(Session session) {
        Transaction transaction = session.beginTransaction();

        var example = new CustomTypeMappingExample(1, new CustomName("Nurislom", "Xasanov"));
        session.persist(example);

        transaction.commit();
    }

    static void get(Session session) {
        var example = session.find(CustomTypeMappingExample.class, 1);
        System.out.println("example = " + example);
    }

}
