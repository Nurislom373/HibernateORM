package org.khasanof.bootstrap.xmlMapping;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * Author: Nurislom
 * <br/>
 * Date: 3/2/2023
 * <br/>
 * Time: 8:11 AM
 * <br/>
 * Package: org.khasanof.bootstrap.xml_mapping
 */
public class XMConfig {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getProperties());

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(registry);
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.default_entity_mode", "dynamic-map");
        return properties;
    }

}
