package org.khasanof.domainModel.basicValues.temporalAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 6:13 PM
 * <br/>
 * Package: org.khasanof.basicValues.temporalAnnotation
 */
public class TemporalMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var date = Date.valueOf(LocalDate.now());
            var temporalExample = new TemporalExample(date, date, date);

            session.persist(temporalExample);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
