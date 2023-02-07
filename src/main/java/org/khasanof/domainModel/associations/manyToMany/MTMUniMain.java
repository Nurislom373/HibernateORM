package org.khasanof.domainModel.associations.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/5/2023
 * <br/>
 * Time: 12:17 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToMany
 */
public class MTMUniMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void lst(Session session) {
        var list = session.createQuery("FROM MTMUniPersonEntity ", MTMUniPersonEntity.class)
                .list();

        System.out.println("list = " + list);
    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var person1 = new MTMUniPersonEntity();
        var person2 = new MTMUniPersonEntity();

        var address1 = new MTMUniAddressEntity("12th Avenue", "12A");
        var address2 = new MTMUniAddressEntity("18th Avenue", "18B");
        var address3 = new MTMUniAddressEntity("18th Avenue", "132B");
        session.persist(address1);
        session.persist(address2);
        session.persist(address3);

        ArrayList<MTMUniAddressEntity> list = new ArrayList<>();
        list.add(address1);
        list.add(address2);
        list.add(address3);

        person1.setAddresses(list);
        person2.setAddresses(list);

        session.persist(person1);
        session.persist(person2);

        transaction.commit();
    }

}
