package org.khasanof.extra.orderByAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 7:45 PM
 * <br/>
 * Package: org.khasanof.extra.orderByAnnotation
 */
public class OBABMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
//            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        OBBook bookOne = new OBBook(1, "Spring In Action 6th");
        OBBook bookTwo = new OBBook(2, "Modern Java In Action");
        session.persist(bookOne);
        session.persist(bookTwo);

        OBAuthor author = new OBAuthor(1, "Oleg", List.of(bookOne, bookTwo));
        session.persist(author);

        transaction.commit();
    }

    static void lst(Session session) {
        List<OBAuthor> list = session.createQuery("FROM ob_author", OBAuthor.class)
                .list();

        System.out.println("list = " + list);
    }

}
