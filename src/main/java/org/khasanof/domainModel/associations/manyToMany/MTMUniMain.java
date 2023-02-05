package org.khasanof.domainModel.associations.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

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

    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var person1 = new MTMUniPersonEntity();
        var person2 = new MTMUniPersonEntity();

        var address1 = new MTMUniAddressEntity("12th Avenue", "12A");
        var address2 = new MTMUniAddressEntity("18th Avenue", "18B");
        var address3 = new MTMUniAddressEntity("18th Avenue", "132B");

        person1.getList().add(address1);
        person1.getList().add(address2);
        person1.getList().add(address3);
        person2.getList().add(address1);
        person2.getList().add(address2);

        session.persist(person1);
        session.persist(person2);
    }

}
