package org.khasanof.config.javaBasedConfig;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Nurislom
 * @see org.khasanof.config.javaBasedConfig
 * @since 10/1/2023 6:53 PM
 */
public class CustomSessionFactoryBuilder {

    public SessionFactory sessionFactoryBuild(Class entity) {
        Configuration configuration = new Configuration();
        configuration.setProperties(JavaBasedConfig.getProperties());
        configuration.addAnnotatedClass(entity);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(registry);
    }

}
