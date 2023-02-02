package org.khasanof.domainModel.associations.manyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/1/2023
 * <br/>
 * Time: 9:01 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.manyToOneAnn
 */
public class MTOMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            add(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var mtoPerson = new MTOPerson();
        mtoPerson.setName("Nurislom");
        session.persist(mtoPerson);

        var mtoPhone = new MTOPhone();
        mtoPhone.setNumber("+998993733273");
        mtoPhone.setPerson(mtoPerson);
        session.persist(mtoPhone);

        transaction.commit();
    }

    static void add(Session session) {
        Transaction transaction = session.beginTransaction();

        var person = session.find(MTOPerson.class, 1);
        System.out.println("person = " + person);

        var mtoPhone = new MTOPhone();
        mtoPhone.setNumber("+6738297089432");
        mtoPhone.setPerson(person);
        session.persist(mtoPhone);

        transaction.commit();
    }

    static void lst(Session session) {
        var list = session.createQuery("FROM MTOPhone", MTOPhone.class)
                .list();

        System.out.println("list = " + list);
    }
}
