package org.khasanof.domainModel.identifiers.simpleIdentifier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/30/2023
 * <br/>
 * Time: 9:12 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.simpleIdentifier
 */
public class SimpleIdentifierMain {

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

        var simple = new SimpleIdentifiersGenExample();
        session.persist(simple);

        transaction.commit();
    }

    static void lst(Session session) {
        var list = session.createQuery("FROM simple_identifiers_gen_exm")
                .list();

        System.out.println("list = " + list);
    }
}
