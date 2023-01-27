package org.khasanof.domainModel.embeddableValues.customTypeMapping;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.ValueAccess;
import org.hibernate.usertype.CompositeUserType;

import java.io.Serializable;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/27/2023
 * <br/>
 * Time: 10:49 PM
 * <br/>
 * Package: org.khasanof.domainModel.embeddableValues.customTypeMapping
 */
public class CustomNameCompositeType implements CompositeUserType<CustomName> {

    public static class CustomNameMapper {
        String firstName;
        String lastName;
    }

    /**
     * Get the value of a property.
     *
     * @param component an instance of class mapped by this "type"
     * @param property  the property index
     * @return the property value
     * @throws HibernateException
     */
    @Override
    public Object getPropertyValue(CustomName component, int property) throws HibernateException {
        return switch (property) {
            case 0 -> component.first();
            case 1 -> component.last();
            default -> throw new IllegalStateException("Unexpected value: " + property);
        };
    }

    @Override
    public CustomName instantiate(ValueAccess values, SessionFactoryImplementor sessionFactory) {
        String first = values.getValue(0, String.class);
        String last = values.getValue(1, String.class);
        return new CustomName(first, last);
    }

    /**
     * The class that represents the embeddable mapping of the type.
     *
     * @return Class
     */
    @Override
    public Class<?> embeddable() {
        return CustomNameMapper.class;
    }

    /**
     * The class returned by {@code instantiate()}.
     *
     * @return Class
     */
    @Override
    public Class<CustomName> returnedClass() {
        return CustomName.class;
    }

    /**
     * Compare two instances of the class mapped by this type for persistence "equality".
     * Equality of the persistent state.
     *
     * @param x
     * @param y
     */
    @Override
    public boolean equals(CustomName x, CustomName y) {
        return x == y || x != null && Objects.equals( x.first(), y.first() )
                && Objects.equals( x.last(), y.last() );
    }

    /**
     * Get a hashcode for the instance, consistent with persistence "equality"
     *
     * @param x
     */
    @Override
    public int hashCode(CustomName x) {
        return Objects.hash(x.first(), x.last());
    }

    /**
     * Return a deep copy of the persistent state, stopping at entities and at
     * collections. It is not necessary to copy immutable objects, or null
     * values, in which case it is safe to simply return the argument.
     *
     * @param value the object to be cloned, which may be null
     * @return Object a copy
     */
    @Override
    public CustomName deepCopy(CustomName value) {
        return value;
    }

    /**
     * Are objects of this type mutable?
     *
     * @return boolean
     */
    @Override
    public boolean isMutable() {
        return false;
    }

    /**
     * Transform the object into its cacheable representation. At the very least this
     * method should perform a deep copy if the type is mutable. That may not be enough
     * for some implementations, however; for example, associations must be cached as
     * identifier values. (optional operation)
     *
     * @param value the object to be cached
     * @return a cacheable representation of the object
     */
    @Override
    public Serializable disassemble(CustomName value) {
        return new String[]{value.first(), value.last()};
    }

    /**
     * Reconstruct an object from the cacheable representation. At the very least this
     * method should perform a deep copy if the type is mutable. (optional operation)
     *
     * @param cached the object to be cached
     * @param owner  the owner of the cached object
     * @return a reconstructed object from the cacheable representation
     */
    @Override
    public CustomName assemble(Serializable cached, Object owner) {
        final String[] parts = (String[]) cached;
        return new CustomName( parts[0], parts[1] );
    }

    /**
     * During merge, replace the existing (target) value in the entity we are merging to
     * with a new (original) value from the detached entity we are merging. For immutable
     * objects, or null values, it is safe to simply return the first parameter. For
     * mutable objects, it is safe to return a copy of the first parameter. For objects
     * with component values, it might make sense to recursively replace component values.
     *
     * @param detached the value from the detached entity being merged
     * @param managed  the value in the managed entity
     * @param owner
     * @return the value to be merged
     */
    @Override
    public CustomName replace(CustomName detached, CustomName managed, Object owner) {
        return detached;
    }
}
