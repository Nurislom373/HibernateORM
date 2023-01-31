package org.khasanof.domainModel.identifiers.customIdentifiers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/31/2023
 * <br/>
 * Time: 7:36 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.customIdentifiers
 */
public class MyGenEntityMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var myGen = new MyGenEntity("Jeck");
        session.persist(myGen);

        transaction.commit();
    }

    static void lst(Session session) {
        List<MyGenEntity> list = session.createQuery("FROM my_gen", MyGenEntity.class)
                .list();

        System.out.println("list = " + list);
    }
}
