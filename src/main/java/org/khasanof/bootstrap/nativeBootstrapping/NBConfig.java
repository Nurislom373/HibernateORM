package org.khasanof.bootstrap.nativeBootstrapping;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.khasanof.domainModel.basicValues.attributeConverter.Person;

import java.io.File;

/**
 * Author: Nurislom
 * <br/>
 * Date: 3/2/2023
 * <br/>
 * Time: 8:20 AM
 * <br/>
 * Package: org.khasanof.bootstrap.native_bootstrapping
 */
public class NBConfig {

    public void setConfig() {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();

        MetadataSources sources = new MetadataSources(serviceRegistry);

        // alternatively, we can build the MetadataSources without passing
        // a service registry, in which case it will build a default
        // BootstrapServiceRegistry to use.  But the approach shown
        // above is preferred
        // MetadataSources sources = new MetadataSources();

        // add a class using JPA/Hibernate annotations for mapping
        sources.addAnnotatedClasses(Person.class);

        // add the name of a class using JPA/Hibernate annotations for mapping.
        // differs from above in that accessing the Class is deferred which is
        // important if using runtime bytecode-enhancement
        sources.addAnnotatedClassName("org.khasanof.domainModel.basicValues.attributeConverter.Person");

        // Read package-level metadata.
        sources.addPackage("org.khasanof");

        // Adds the named hbm.xml resource as a source: which performs the
        // classpath lookup and parses the XML
        sources.addResource("org/khasanof/bootstrap/xmlMapping/book-mapping.xml");

        // Adds the named JPA orm.xml resource as a source: which performs the
        // classpath lookup and parses the XML
        sources.addResource("org/hibernate/example/Product.orm.xml");

        // Read all mapping documents from a directory tree.
        // Assumes that any file named *.hbm.xml is a mapping document.
        sources.addDirectory(new File("."));

        // Read mappings from a particular XML file
        sources.addFile(new File("./mapping.xml"));

        // Read all mappings from a jar file.
        // Assumes that any file named *.hbm.xml is a mapping document.
        sources.addJar(new File("./entities.jar"));

    }

}
