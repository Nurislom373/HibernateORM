package org.khasanof.domainModel.embeddableValues.customInstaniation;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.EmbeddableInstantiator;
import org.hibernate.metamodel.spi.ValueAccess;

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

    /**
     * Create an instance of the embeddable
     *
     * @param valueAccess
     * @param sessionFactory
     */
    @Override
    public Object instantiate(ValueAccess valueAccess, SessionFactoryImplementor sessionFactory) {
        String first = valueAccess.getValue(0, String.class);
        String last = valueAccess.getValue(1, String.class);
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
        return false;
    }

    /**
     * @param object
     * @param sessionFactory
     * @see Class#equals
     */
    @Override
    public boolean isSameClass(Object object, SessionFactoryImplementor sessionFactory) {
        return false;
    }
}
