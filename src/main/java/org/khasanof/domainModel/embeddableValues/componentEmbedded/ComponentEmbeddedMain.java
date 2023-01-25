package org.khasanof.domainModel.embeddableValues.componentEmbedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/25/2023
 * <br/>
 * Time: 10:11 PM
 * <br/>
 * Package: org.khasanof.embeddableValues.componentEmbedded
 */
public class ComponentEmbeddedMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var example = new ComponentEmbeddedExample( "Lorem Ipsum",
                    new Publisher("Uzbek", "Tashkent"));

            session.persist(example);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
