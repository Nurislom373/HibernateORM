package org.khasanof.domainModel.identifiers.customIdentifiers;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;
import java.util.stream.Stream;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/31/2023
 * <br/>
 * Time: 7:21 PM
 * <br/>
 * Package: org.khasanof.domainModel.identifiers.customIdentifiers
 */
public class MyGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    /**
     * Generate a new identifier.
     *
     * @param session The session from which the request originates
     * @param object  the entity or collection (idbag) for which the id is being generated
     * @return a new identifier
     * @throws HibernateException Indicates trouble generating the identifier
     */
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        String query = String.format("select %s from %s", session.getEntityPersister(object.getClass().getName(), object)
                .getIdentifierPropertyName(), object.getClass().getSimpleName());

        Stream<?> stream = session.createQuery(query, object.getClass()).stream();

        long max = stream.map(o -> o.toString().replace(prefix + "-", ""))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);

        return prefix + "-" + (max + 1);
    }


    /**
     * Configure this instance, given the value of parameters
     * specified by the user as {@code &lt;param&gt;} elements.
     * <p>
     * This method is called just once, following instantiation, and before {@link #registerExportables(Database)}.
     *
     * @param type            The id property type descriptor
     * @param params          param values, keyed by parameter name
     * @param serviceRegistry Access to service that may be needed.
     * @throws MappingException If configuration fails.
     */
    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        prefix = params.getProperty("prefix");
    }
}
