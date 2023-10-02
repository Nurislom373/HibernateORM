package org.khasanof.bootstrap.nativeBootstrapping;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.khasanof.domainModel.basicValues.attributeConverter.Person;

/**
 * Author: Nurislom
 * <br/>
 * Date: 3/2/2023
 * <br/>
 * Time: 8:29 AM
 * <br/>
 * Package: org.khasanof.bootstrap.nativeBootstrapping
 */
public class BuildMetaData {

    public void build() {

        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClassName("org.hibernate.example.Customer")
                .addResource("org/hibernate/example/Order.hbm.xml")
                .addResource("org/hibernate/example/Product.orm.xml")
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

    }

}
