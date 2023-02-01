package org.khasanof.domainModel.identifiers.primaryKeyJoinColumnAnn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 6:57 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.derivedIdentifiers
 */
public class DerivedPKEntityMain {

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

        DerivedPKEntity pkEntity = new DerivedPKEntity(2L, "+785745376347543");
        session.persist(pkEntity);

        DerivedPKDetailsEntity pkDetails = new DerivedPKDetailsEntity(3L, "fjdsvhfvdhsg", pkEntity);
        session.persist(pkDetails);

        transaction.commit();
    }

    static void lst(Session session) {
        List<DerivedPKDetailsEntity> list = session.createQuery("FROM derived_pk_details_entity",
                DerivedPKDetailsEntity.class).list();

        System.out.println("list = " + list);
    }
}
