package org.khasanof.config.javaBasedConfig;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.khasanof.domainModel.associations.manyToMany.MTMUniPostEntity;
import org.khasanof.domainModel.associations.manyToMany.MTMUniTagEntity;
import org.khasanof.domainModel.associations.manyToOne.MTOPerson;
import org.khasanof.domainModel.associations.manyToOne.MTOPhone;
import org.khasanof.domainModel.associations.notFoundAnnotation.NFCityEntity;
import org.khasanof.domainModel.associations.notFoundAnnotation.NFPersonEntity;
import org.khasanof.domainModel.associations.oneToMany.OTMAccountEntity;
import org.khasanof.domainModel.associations.oneToMany.OTMEmployeeEntity;
import org.khasanof.domainModel.associations.oneToMany.OTMPerson;
import org.khasanof.domainModel.associations.oneToMany.OTMPhone;
import org.khasanof.domainModel.associations.oneToOne.OTOBidPhoneDetailsEntity;
import org.khasanof.domainModel.associations.oneToOne.OTOBidPhoneEntity;
import org.khasanof.domainModel.associations.oneToOne.OTOUniPhoneDetailsEntity;
import org.khasanof.domainModel.associations.oneToOne.OTOUniPhoneEntity;
import org.khasanof.domainModel.basicValues.CCUGGTimestamp.*;
import org.khasanof.domainModel.basicValues.attributeConverter.Person;
import org.khasanof.domainModel.basicValues.basicAnnotation.Product;
import org.khasanof.domainModel.basicValues.formulaAnnotation.Account;
import org.khasanof.domainModel.basicValues.formulaAnnotation.Author;
import org.khasanof.domainModel.basicValues.jdbcTypeCodeAnnotation.JdbcTypeCodeExample;
import org.khasanof.domainModel.basicValues.temporalAnnotation.TemporalExample;
import org.khasanof.domainModel.basicValues.timeZoneStorage.TimeZoneStorageExample;
import org.khasanof.domainModel.collections.elementCollection.EntityWithList;
import org.khasanof.domainModel.collections.listArrayType.Event;
import org.khasanof.domainModel.embeddableValues.componentEmbedded.ComponentEmbeddedExample;
import org.khasanof.domainModel.embeddableValues.customTypeMapping.CustomTypeMappingExample;
import org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes.Country;
import org.khasanof.domainModel.embeddableValues.overridingEmbeddableTypes.OvrEmbedTypesExample;
import org.khasanof.domainModel.embeddableValues.targetAnnoatation.TargetAnnExample;
import org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery.ETAccount;
import org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery.ETAccountTransaction;
import org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery.ETClient;
import org.khasanof.domainModel.entityTypes.mappingTheEntityToSQLQuery.ETSQLQueryEntity;
import org.khasanof.domainModel.identifiers.derivedIdentifiers.DerivedIdn;
import org.khasanof.domainModel.identifiers.derivedIdentifiers.DerivedIdnDetails;
import org.khasanof.domainModel.identifiers.primaryKeyJoinColumnAnn.DerivedPKDetailsEntity;
import org.khasanof.domainModel.identifiers.primaryKeyJoinColumnAnn.DerivedPKEntity;
import org.khasanof.extra.orderByAnnotation.OBAuthor;
import org.khasanof.extra.orderByAnnotation.OBBook;
import org.khasanof.introduction.entity.AuthUserEntity;

import java.util.Properties;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/22/2023
 * <br/>
 * Time: 6:25 PM
 * <br/>
 * Package: org.khasanof.config.javaBasedConfig
 */
public class JavaBasedConfig {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "2004";
    private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
    private static final String SHOW_SQL = "true";
    private static final String HBM2DDL_AUTO = "update";

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getProperties());
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(AuthUserEntity.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(TemporalExample.class);
        configuration.addAnnotatedClass(TimeZoneStorageExample.class);
        configuration.addAnnotatedClass(JdbcTypeCodeExample.class);
        configuration.addAnnotatedClass(CurrentTimestampAnnotationExample.class);
        configuration.addAnnotatedClass(CreationTimestampAnnotationExample.class);
        configuration.addAnnotatedClass(UpdateTimestampAnnotationExample.class);
        configuration.addAnnotatedClass(GeneratedAnnotationExample.class);
        configuration.addAnnotatedClass(CustomGeneratedAnnotationExample.class);
        configuration.addAnnotatedClass(ComponentEmbeddedExample.class);
        configuration.addAnnotatedClass(OvrEmbedTypesExample.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(TargetAnnExample.class);
        configuration.addAnnotatedClass(CustomTypeMappingExample.class);
        configuration.addAnnotatedClass(ETAccount.class);
        configuration.addAnnotatedClass(ETAccountTransaction.class);
        configuration.addAnnotatedClass(ETClient.class);
        configuration.addAnnotatedClass(ETSQLQueryEntity.class);
        configuration.addAnnotatedClass(DerivedIdn.class);
        configuration.addAnnotatedClass(DerivedIdnDetails.class);
        configuration.addAnnotatedClass(DerivedPKEntity.class);
        configuration.addAnnotatedClass(DerivedPKDetailsEntity.class);
        configuration.addAnnotatedClass(OBAuthor.class);
        configuration.addAnnotatedClass(OBBook.class);
        configuration.addAnnotatedClass(MTOPerson.class);
        configuration.addAnnotatedClass(MTOPhone.class);
        configuration.addAnnotatedClass(OTMPerson.class);
        configuration.addAnnotatedClass(OTMPhone.class);
        configuration.addAnnotatedClass(OTMAccountEntity.class);
        configuration.addAnnotatedClass(OTMEmployeeEntity.class);
        configuration.addAnnotatedClass(OTOUniPhoneEntity.class);
        configuration.addAnnotatedClass(OTOUniPhoneDetailsEntity.class);
        configuration.addAnnotatedClass(OTOBidPhoneDetailsEntity.class);
        configuration.addAnnotatedClass(OTOBidPhoneEntity.class);
        configuration.addAnnotatedClass(MTMUniTagEntity.class);
        configuration.addAnnotatedClass(MTMUniPostEntity.class);
        configuration.addAnnotatedClass(NFCityEntity.class);
        configuration.addAnnotatedClass(NFPersonEntity.class);
        configuration.addAnnotatedClass(EntityWithList.class);
        configuration.addAnnotatedClass(Event.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(registry);
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, DRIVER);
        properties.setProperty(Environment.URL, URL);
        properties.setProperty(Environment.USER, USER);
        properties.setProperty(Environment.PASS, PASS);
        properties.setProperty(Environment.DIALECT, DIALECT);
        properties.setProperty(Environment.SHOW_SQL, SHOW_SQL);
        properties.setProperty(Environment.HBM2DDL_AUTO, HBM2DDL_AUTO);
        return properties;
    }

}
