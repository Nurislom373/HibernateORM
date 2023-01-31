package org.khasanof.domainModel.identifiers.compositeIdentifiers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/30/2023
 * <br/>
 * Time: 11:47 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.compositeIdentifiers
 */
public class OrderEntryMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            lst(session);
            OrderEntry entry = gte(session, new OrderEntryPK(1, 1));
            System.out.println("entry = " + entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var order = new OrderEntry(new OrderEntryPK(1, 1), "Phone", "Lorem Ipsum");
        session.persist(order);

        transaction.commit();
    }

    static void lst(Session session) {
        List<OrderEntry> list = session.createQuery("FROM order_entry", OrderEntry.class)
                .list();

        System.out.println("list = " + list);
    }

    static OrderEntry gte(Session session, OrderEntryPK entryPK) {
        return session.find(OrderEntry.class, entryPK);
    }

}
