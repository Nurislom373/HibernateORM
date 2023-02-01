# Derived Identifiers

### Question

I need to map a one-to-one association in which the primary key value of one entity is also used as the primary key
value of the other entity. How can I do that with JPA or Hibernate?

<hr/>

Men bir ob'ektning asosiy kalit qiymati boshqa ob'ektning asosiy kalit qiymati sifatida ishlatiladigan birma-bir
assotsiatsiyani xaritalashim kerak. Buni JPA yoki Hibernate bilan qanday qilishim mumkin?

### JPA @MapsId

@MapsId Annotatsiyasi bir entityni primary keyni boshqa bir entityning primary key sifatida ishlatimoqchi bo'lganimizda
foydalanaishimiz mumkin. 

<hr/>

Java Persistence 2.0 added support for derived identifiers which allow an entity to borrow the identifier from a
many-to-one or one-to-one association.

```java

@Entity(name = "derived_idn")
public class DerivedIdn {

    @Id
    private Long id;

    @NaturalId
    private String registrationNumber;

    // ...
}
```

```java

@Entity(name = "derived_idn_details")
public class DerivedIdnDetails {

    @Id
    private Long id;

    private String nickName;

    @OneToOne
    @MapsId
    private DerivedIdn derivedIdn;

    // ...
}
```

In the example above, the `DerivedIdnDetails` entity uses the id column for both the entity identifier and for the
one-to-one association to the `DerivedIdn` entity. The value of the `DerivedIdnDetails` entity identifier is "derived"
from the
identifier of its parent `DerivedIdn` entity.