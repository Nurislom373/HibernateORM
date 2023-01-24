package org.khasanof.basicValues.timeZoneStorage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 6:28 PM
 * <br/>
 * Package: org.khasanof.basicValues.timeZoneStorage
 */
public class TimeZoneStorageMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            var timeZone = new TimeZoneStorageExample();
            timeZone.setZonedDateTimeColumn(ZonedDateTime.now());
            timeZone.setOffsetDateTimeColumn(OffsetDateTime.now());

            session.persist(timeZone);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
