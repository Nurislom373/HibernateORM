package org.khasanof.domainModel.naturalIds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.Optional;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/28/2023
 * <br/>
 * Time: 3:08 PM
 * <br/>
 * Package: org.khasanof.domainModel.naturalIds
 */
public class NaturalBookMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            gte(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        NaturalBook naturalBook = new NaturalBook(1, "ftgyhjf", "ghj", "788678-7879");
        session.persist(naturalBook);

        transaction.commit();

        Session unwrap = session.unwrap(Session.class);
        NaturalBook book = unwrap.bySimpleNaturalId(NaturalBook.class).load("788678-7879");
        System.out.println(book);
    }

    private static void gte(Session session) {
        NaturalBook book = session.unwrap(Session.class)
                .byNaturalId(NaturalBook.class)
                .using("isbn", "788678-7879")
                .load();

        System.out.println("book = " + book);
    }

}
