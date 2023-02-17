package org.khasanof.domainModel.associations.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/2/2023
 * <br/>
 * Time: 7:14 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToOne
 */
public class OTOUnidirectionalMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var details = new OTOUniPhoneDetailsEntity();
        details.setTechnology("Redmi");
        details.setProvider("Apple");
        session.persist(details);

        var phone = new OTOUniPhoneEntity();
        phone.setNumber("+567894032");
        phone.setDetails(details);
        session.persist(phone);

        transaction.commit();
    }

    static void lst(Session session) {
        var list = session.createQuery("FROM OTOUniPhoneEntity", OTOUniPhoneEntity.class)
                .list();
        System.out.println("list = " + list);
    }



}
