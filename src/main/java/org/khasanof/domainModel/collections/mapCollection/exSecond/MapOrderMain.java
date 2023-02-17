package org.khasanof.domainModel.collections.mapCollection.exSecond;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 11:06 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection.exSecond
 */
public class MapOrderMain {

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

        MapOrder order = new MapOrder();

        Map<String, Double> map = new HashMap<>();
        map.put("Phone", 200.00D);
        map.put("Laptop", 900.00D);
        order.setItemPriceMap(map);
        session.persist(order);

        transaction.commit();
    }

    private static void lst(Session session) {
        List<MapOrder> list = session.createQuery("FROM MapOrder", MapOrder.class).list();
        System.out.println("list = " + list);
    }
}
