package org.khasanof.basicValues.CCUGGTimestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 9:08 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */
public class GeneratedAnnotationMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var generatedAnnotationExample = new GeneratedAnnotationExample("Nurislom", "Xasanov");
            session.persist(generatedAnnotationExample);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
