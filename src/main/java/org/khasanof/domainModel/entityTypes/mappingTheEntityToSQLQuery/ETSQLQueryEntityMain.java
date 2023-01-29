package org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.khasanof.config.javaBasedConfig.JavaBasedConfig;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/29/2023
 * <br/>
 * Time: 6:22 PM
 * <br/>
 * Package: org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery
 */
public class ETSQLQueryEntityMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = JavaBasedConfig.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            sve(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sve(Session session) {
        Transaction transaction = session.beginTransaction();

        ETClient client = new ETClient();
        client.setId(1);
        client.setFirstName("Nurislom");
        client.setLastName("Xasanov");
        session.persist(client);

        ETAccount account = new ETAccount();
        account.setId(1);
        account.setClient(client);
        account.setDescription("lorem ipsum");
        session.persist(account);

        ETAccountTransaction accountTransaction = new ETAccountTransaction();
        accountTransaction.setId(1);
        accountTransaction.setAccount(account);
        accountTransaction.setCents(100 * 7000);
        session.persist(accountTransaction);
        transaction.commit();

        ETSQLQueryEntity entity = session.createQuery("FROM EtSQLQueryEntity et where et.id = :id",
                        ETSQLQueryEntity.class)
                .setParameter("id", 1)
                .getSingleResult();

        System.out.println("entity = " + entity);
    }

}
