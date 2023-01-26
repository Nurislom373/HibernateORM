package org.khasanof.domainModel.embeddableValues.targetAnnoatation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/26/2023
 * <br/>
 * Time: 10:19 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.targetAnnoatation
 */
public class TargetAnnMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            save(session);
            find(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void save(Session session) {
        Transaction transaction = session.beginTransaction();

        var cluj = new TargetAnnExample(1, "Cluj", new GPS(46.77120, 23.62360));
        session.persist(cluj);

        transaction.commit();
    }

    private static void find(Session session) {
        TargetAnnExample example = session.find(TargetAnnExample.class, 1);
        System.out.println("example = " + example);
    }

}
