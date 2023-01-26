package org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/25/2023
 * <br/>
 * Time: 11:20 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes
 */
public class OvrEmbedTypesMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            OvrEmbedTypesExample id = findById(session, 1);
            System.out.println("id = " + id);

            List<Country> country = getCountry(session);
            System.out.println("country = " + country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(Session session) {
        Transaction transaction = session.beginTransaction();

        Country tashkent = new Country("Tashkent");
        Country samarqand = new Country("Samarqand");
        session.persist(tashkent);
        session.persist(samarqand);

        var example = new OvrEmbedTypesExample("Java Persistence Book", "Tamen",
                new Publisher("fdsugf", tashkent), new Publisher("fdsyfvyds", samarqand));
        session.persist(example);

        transaction.commit();
    }

    public static OvrEmbedTypesExample findById(Session session, Integer id) {
        return session.find(OvrEmbedTypesExample.class, id);
    }

    public static List<Country> getCountry(Session session) {
        return session.createQuery("FROM country", Country.class)
                .list();
    }

}
