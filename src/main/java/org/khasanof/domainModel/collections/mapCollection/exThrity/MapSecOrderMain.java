package org.khasanof.domainModel.collections.mapCollection.exThrity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 11:18 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection.exThrity
 */
public class MapSecOrderMain {

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

        Map<String, MapItem> map = new HashMap<>();

        MapItem item1 = new MapItem("Laptop", 900.00D,
                MapItemType.MODE, new Date(2020, Calendar.NOVEMBER, 18));
        MapItem item2 = new MapItem("Phone", 200.00D,
                MapItemType.NO_MODE, new Date(2009, Calendar.NOVEMBER, 18));

        map.put("laptop", item1);
        map.put("phone", item2);

        session.persist(item1);
        session.persist(item2);

        MapSecOrder order = new MapSecOrder();
        order.setItemMap(map);
        session.persist(map);

        transaction.commit();
    }

    private static void lst(Session session) {
        List<MapSecOrder> list = session.createQuery("FROM MapSecOrder", MapSecOrder.class).list();
        System.out.println("list = " + list);
    }

}
