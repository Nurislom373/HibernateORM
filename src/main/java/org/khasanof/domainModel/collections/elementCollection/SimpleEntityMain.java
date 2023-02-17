package org.khasanof.domainModel.collections.elementCollection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/16/2023
 * <br/>
 * Time: 10:18 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections
 */
public class SimpleEntityMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        SimpleEntity entity1 = new SimpleEntity("udbfgu", "fdnsfkjs");
        SimpleEntity entity2 = new SimpleEntity("shgiuf", "fdnsfkjs");

        EntityWithList entityWithList = new EntityWithList();
        entityWithList.setEntities(List.of(entity1, entity2));

        session.persist(entityWithList);

        transaction.commit();
    }

    private static void lst(Session session) {
        var list = session.createQuery("FROM EntityWithList", EntityWithList.class).list();
        System.out.println("list = " + list);
    }

}
