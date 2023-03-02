# Dynamic Model

Persistent entities do not necessarily have to be represented as POJO/JavaBean classes. Hibernate also supports dynamic
models (using Map of Maps at runtime). With this approach, you do not write persistent classes, only mapping files.

A given entity has just one entity mode within a given SessionFactory. This is a change from previous versions which
allowed to define multiple entity modes for an entity and to select which to load. Entity modes can now be mixed within
a domain model; a dynamic entity might reference a POJO entity and vice versa.

```xml
<!DOCTYPE hibernate-mapping PUBLIC
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

<hibernate-mapping>
    <class entity-name="Book">
        <id name="isbn" column="isbn" length="32" type="string"/>

        <property name="title" not-null="true" length="50" type="string"/>

        <property name="author" not-null="true" length="50" type="string"/>

    </class>
</hibernate-mapping>
```

After you defined your entity mapping, you need to instruct Hibernate to use the dynamic mapping mode:

```java
settings.put("hibernate.default_entity_mode", "dynamic-map");
```

```java
Map<String, String> book = new HashMap<>();
book.put("isbn", "978-9730228236");
book.put("title", "High-Performance Java Persistence");
book.put("author", "Vlad Mihalcea");

entityManager
	.unwrap(Session.class)
	.save("Book", book);
```