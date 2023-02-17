package org.khasanof.domainModel.collections.listArrayType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.UUID;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 5:51 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.listArrayType
 */
public class EventMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            fnd(session);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        session.persist(
                Event.builder()
                        .sensorIds(Arrays.asList(
                                UUID.fromString(
                                        "c65a3bcb-8b36-46d4-bddb-ae96ad016eb1"
                                ),
                                UUID.fromString(
                                        "72e95717-5294-4c15-aa64-a3631cf9a800"
                                )
                        ))
                        .sensorNames(Arrays.asList("Temperature", "Pressure"))
                        .sensorValues(Arrays.asList(12, 756))
                        .sensorLongValues(Arrays.asList(42L, 9223372036854775800L))
                        .dateValues(Arrays.asList(
                                java.sql.Date.valueOf(LocalDate.of(1991, 12, 31)),
                                java.sql.Date.valueOf(LocalDate.of(1990, 1, 1))
                        ))
                        .timestampValues(Arrays.asList(
                                Date.from(
                                        LocalDate.of(1991, 12, 31)
                                                .atStartOfDay()
                                                .atZone(ZoneId.systemDefault())
                                                .toInstant()
                                ),
                                Date.from(
                                        LocalDate.of(1990, 1, 1)
                                                .atStartOfDay()
                                                .atZone(ZoneId.systemDefault())
                                                .toInstant()
                                )
                        ))
                        .build()
        );

        transaction.commit();
    }

    private static void fnd(Session session) {
        Event event = session.find(Event.class, 1L);

        System.out.println("event = " + event);
    }




}
