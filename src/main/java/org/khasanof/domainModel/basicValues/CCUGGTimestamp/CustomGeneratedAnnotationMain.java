package org.khasanof.domainModel.basicValues.CCUGGTimestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 9:21 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */
public class CustomGeneratedAnnotationMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var example = new CustomGeneratedAnnotationExample();
            session.persist(example);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
