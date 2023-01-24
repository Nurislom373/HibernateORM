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
 * Time: 8:06 PM
 * <br/>
 * Package: org.khasanof.basicValues.CCUGGTimestamp
 */
public class UpdateTimestampAnnotationMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            var updateTimestampAnnotationExample = new UpdateTimestampAnnotationExample();
            updateTimestampAnnotationExample.setUpdatedBy("Nurislom");

            session.persist(updateTimestampAnnotationExample);



            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
