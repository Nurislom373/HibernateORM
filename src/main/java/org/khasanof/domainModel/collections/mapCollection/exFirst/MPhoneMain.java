package org.khasanof.domainModel.collections.mapCollection.exFirst;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/17/2023
 * <br/>
 * Time: 9:46 PM
 * <br/>
 * Package: org.khasanof.domainModel.collections.mapCollection
 */
public class MPhoneMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
            lst(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        MPerson mPerson = new MPerson();

        Map<MPhone, Date> map = new HashMap<>();
        map.put(new MPhone(MPhoneType.LAND_LINE, "028-234-9876"), new Date());
        map.put(new MPhone(MPhoneType.MOBILE, "072-122-9876"), new Date());

        mPerson.setPhoneRegister(map);
        session.persist(mPerson);

        transaction.commit();
    }

    private static void lst(Session session) {
        List<MPerson> list = session.createQuery("FROM MPerson", MPerson.class).list();
        System.out.println("list = " + list);
    }

}
