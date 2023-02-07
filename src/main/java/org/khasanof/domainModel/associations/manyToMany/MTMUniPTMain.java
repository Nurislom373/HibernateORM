package org.khasanof.domainModel.associations.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/7/2023
 * <br/>
 * Time: 3:40 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToMany
 */
public class MTMUniPTMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
//            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void lst(Session session) {
        List<MTMUniPostEntity> lst = session.createQuery("FROM MTMUniPostEntity",
                        MTMUniPostEntity.class).list();
        lst.forEach(obj -> {
            System.out.println(obj.getTitle());
        });
    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var post1 = new MTMUniPostEntity("JPA with Hibernate");
        var post2 = new MTMUniPostEntity("Native Hibernate");

        var tag1 = new MTMUniTagEntity("Java");
        var tag2 = new MTMUniTagEntity("Hibernate");

        post1.addTag(tag1);
        post1.addTag(tag2);
        post2.addTag(tag1);

        session.persist(post1);
        session.persist(post2);

        transaction.commit();
    }

}
