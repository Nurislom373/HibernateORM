package org.khasanof.domainModel.associations.notFoundAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/12/2023
 * <br/>
 * Time: 9:40 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.notFoundAnnotation
 */
public class NFMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
//             sve(session);
//             gte(session);
             dte(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dte(Session session) {
        Transaction transaction = session.beginTransaction();
        session.createMutationQuery("delete NFCityEntity").executeUpdate();

        transaction.commit();

        NFPersonEntity person = session.find(NFPersonEntity.class, 1);
        NFCityEntity city = person.getCity();

        if (city == null) {
            System.out.println("City null!");
        }
    }

    private static void gte(Session session) {
        NFPersonEntity person = session.find(NFPersonEntity.class, 1);
        System.out.println(assertEquals("Tashkent", person.getCity().getName()));
    }

    private static void lst(Session session) {
        var list = session.createQuery("FROM NFPersonEntity", NFPersonEntity.class).list();
        System.out.println("list = " + list);
    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var city = new NFCityEntity("Tashkent");
        session.persist(city);

        var person = new NFPersonEntity("Nurislom", city);
        session.persist(person);

        transaction.commit();
    }

    private static boolean assertEquals(String var1, String var2) {
        return var1.equals(var2);
    }
}
