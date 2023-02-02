package org.khasanof.domainModel.associations.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.List;
import java.util.Set;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 5:01 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToMany
 */
public class OTMMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sveAEE(session);
            lstAEE(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sveAEE(Session session) {
        Transaction transaction = session.beginTransaction();
        var account1 = new OTMAccountEntity();
        account1.setNumber("+748357438543");

        var account2 = new OTMAccountEntity();
        account2.setNumber("+74835874375t43");

        var employee = new OTMEmployeeEntity();
        employee.setName("Nurislom");
        employee.setAccounts(Set.of(account1, account2));

        session.persist(employee);
        transaction.commit();
    }

    static void lstAEE(Session session) {
        var list = session.createQuery("FROM OTMEmployeeEntity", OTMEmployeeEntity.class)
                .list();
        System.out.println("list = " + list);
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var phoneOne = new OTMPhone();
        phoneOne.setNumber("+4567382131");
        session.persist(phoneOne);

        var phoneTwo = new OTMPhone();
        phoneTwo.setNumber("+36247632432");
        session.persist(phoneTwo);

        var person = new OTMPerson();
        person.setPhones(List.of(phoneOne, phoneTwo));
        session.persist(person);

        transaction.commit();
    }

    static void lst(Session session) {
        var list = session.createQuery("from otm_person", OTMPerson.class).list();
        System.out.println("list = " + list);
    }

}
