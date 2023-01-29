package org.khasanof.domainModel.entityTypes.persisterAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/29/2023
 * <br/>
 * Time: 7:44 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.persisterAnnotation
 */
public class PersisterAnnMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();



        transaction.commit();
    }
}
