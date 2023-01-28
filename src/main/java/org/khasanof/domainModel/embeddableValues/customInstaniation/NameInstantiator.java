package org.khasanof.domainModel.embeddableValues.customInstaniation;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.EmbeddableInstantiator;
import org.hibernate.metamodel.spi.ValueAccess;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 10:39 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.customInstaniation
 */
public class NameInstantiator implements EmbeddableInstantiator {

    private Logger log = LogManager.getLogManager().getLogger(this.getClass().getName());

    /**
     * Create an instance of the embeddable
     *
     * @param valueAccess
     * @param sessionFactory
     */
    /*
        en - valuesAccess contains attribute values in alphabetical order

        uz - valuesAccess atribut qiymatlarini alifbo tartibida o'z ichiga oladi
     */
    @Override
    public Object instantiate(ValueAccess valueAccess, SessionFactoryImplementor sessionFactory) {
        String first = valueAccess.getValue(0, String.class);
        String last = valueAccess.getValue(1, String.class);
        log.info("Instantiate Name embeddable with NameInstantiator");
        return new Name(first, last);
    }

    /**
     * Performs and "instance of" check to see if the given object is an
     * instance of managed structure
     *
     * @param object
     * @param sessionFactory
     * @see Class#isInstance
     */
    @Override
    public boolean isInstance(Object object, SessionFactoryImplementor sessionFactory) {
        return object instanceof Name;
    }

    /**
     * @param object
     * @param sessionFactory
     * @see Class#equals
     */
    @Override
    public boolean isSameClass(Object object, SessionFactoryImplementor sessionFactory) {
        return object.getClass().equals(Name.class);
    }
}
