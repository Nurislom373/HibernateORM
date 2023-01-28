# Custom Type Mapping

Another approach is to supply the implementation of the `org.hibernate.usertype.CompositeUserType `
contract using `@CompositeType`, which is an extension to the `org.hibernate.metamodel.spi.EmbeddableInstantiator` contract.

There are also corresponding, specialized forms of `@CompositeType` for specific model parts:

+ When mapping a Map, `@CompositeType` describes the Map value while `@MapKeyCompositeType` describes the Map key
+ For collection mappings, `@CompositeType` describes the elements

Here, Name only allows use of the constructor accepting its state. Because this class does not follow Java Bean conventions,
a custom user type for instantiation and state access is needed.

A composite user type needs an embeddable mapper class, which represents the embeddable mapping structure of the type i.e. the way the type would look like if you had the option to write a custom @Embeddable class.

In addition to the instantiation logic, a composite user type also has to provide a way to decompose the returned type into the individual components/properties of the embeddable mapper class through getPropertyValue. The property index, just like in the instantiate method, is based on the alphabetical order of the attribute names of the embeddable mapper class.

The composite user type also needs to provide methods to handle the mutability, equals, hashCode and the cache serialization and deserialization of the returned type.

There are a few ways to specify the composite user type. The @org.hibernate.annotations.CompositeType annotation can be used on the embedded and element collection attributes:

<hr/>

Java CustomName classida faqat konstructor orqali statelarni to'ldira olamiz. Ushbu class Java Bean conventionsitsiyasiga rioya
qilmagani uchun, uning instance yaratish va statega kirish uchun maxsus type kerak. 