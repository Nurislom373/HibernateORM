package org.khasanof.domainModel.identifiers.derivedIdentifiers;

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
 * Time: 11:30 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.derivedIdentifiers
 */
public class DerivedIdnMain {

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

        DerivedIdn idn = new DerivedIdn(1L, "fdubsfjdbs");
        session.persist(idn);

        DerivedIdnDetails details = new DerivedIdnDetails(1L, "khasanof", idn);
        session.persist(details);

        transaction.commit();
    }

    static void lst(Session session) {
        List<DerivedIdnDetails> list = session.createQuery("FROM derived_idn_details",
                        DerivedIdnDetails.class).list();

        System.out.println("list = " + list);
    }

}
