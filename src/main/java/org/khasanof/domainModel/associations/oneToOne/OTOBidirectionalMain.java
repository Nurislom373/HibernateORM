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
 * Time: 9:20 PM
 * <br/>
 * Package: org.khasanof.domainModel.associations.oneToOne
 */
public class OTOBidirectionalMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void lst(Session session) {
        var list = session.createQuery("FROM OTOBidPhoneEntity", OTOBidPhoneEntity.class)
                .list();

        System.out.println("list = " + list);
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        var phone = new OTOBidPhoneEntity();
        phone.setNumber("+567389823");

        var details = new OTOBidPhoneDetailsEntity();
        details.setProvider("T-Mobile");
        details.setTechnology("GSM");

        phone.addDetails(details);
        session.persist(phone);

        transaction.commit();
    }

}
