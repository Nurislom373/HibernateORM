# Composite Identifiers

Besides the simple identifiers we've seen so far, Hibernate also allows us to define composite identifiers.

A composite id is represented by a primary key class with one or more persistent attributes.

The primary key class must fulfil several conditions:

+ It should be defined using @EmbeddedId or @IdClass annotations.
+ It should be public, serializable and have a public no-arg constructor.
+ Finally, it should implement equals() and hashCode() methods.

<hr/>

Hibernate bundan oldingi simpleIdentifier packageda ko'rgan oddiy identifikatorlardan tashqari, Hibernate bizga
Composite identifikatorlarni foydalanish imkoni beradi.

Composite identifikator bir yoki bir nechta doimiy atributga ega primary key class bilan ifodalanadi.

primary key class bir nechta shartlarga javob berishi kerak:

+ U `@EmbeddedId` yoki `@IdClass` annotatsiya qoyilgan bo'lishi kerak.
+ Ushbu class public va `Serializable` interfaceni amalga oshirgan bo'lishi kerak. Hamda public no-arg constructori
  bo'lishi kerak.
+ `equals()` va `hashCode()` methodlarni impl qilgan bolishi ham kerak.

### @EmbeddedId

@Embeddable class can be declared inside another class and used as primary key. We can implement it using the
@EmbeddedId annotation.

<hr/>

@Embeddable qoyilgan classni boshqa bir classni ichida e'lon qilin primary key sifatida ishlatsak bo'ladi.
Uning uchun @EmbeddedId annotatsiyasidan foydalangan amalga oshirishimiz mumkin.

```java

@Embeddable
public class OrderEntryPK implements Serializable {

    private long orderId;
    private long productId;

    // standard constructor, getters, setters
    // equals() and hashCode() 
}
```

<hr/>

```java

@Entity
public class OrderEntry {

    @EmbeddedId
    private OrderEntryPK entryId;

    // ...
}
```

### @IdClass

The @IdClass annotation is similar to the @EmbeddedId. The difference with @IdClass is that the attributes are defined
in the main entity class using @Id for each one.

<hr/>

@IdClass annotatsiyasi @EmbeddedId ga o'xshaydi. @IdClass farqi shundaki, atributlar asosiy entity classda @Id
annotatsiyasi yordamida aniqlanadi.

```java

@Entity
@IdClass(OrderEntryPK.class)
public class OrderEntry {
    @Id
    private long orderId;
    @Id
    private long productId;

    // ...
}
```

Composite identifiers can also contain @ManyToOne attributes.

<hr/>

Composite identifikatorlar @ManyToOne atributlarni ham o'z ichiga olishi mumkin.

```java

@Entity(name = "SystemUser")
public static class SystemUser {

    @EmbeddedId
    private PK pk;

    private String name;

    //Getters and setters are omitted for brevity
}

@Entity(name = "Subsystem")
public static class Subsystem {

    @Id
    private String id;

    private String description;

    //Getters and setters are omitted for brevity
}

@Embeddable
public static class PK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private Subsystem subsystem;

    private String username;

    public PK(Subsystem subsystem, String username) {
        this.subsystem = subsystem;
        this.username = username;
    }

    private PK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PK pk = (PK) o;
        return Objects.equals(subsystem, pk.subsystem) &&
                Objects.equals(username, pk.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subsystem, username);
    }
}
```

Hibernate supports directly modeling @ManyToOne associations in the Primary Key class, whether @EmbeddedId or @IdClass.

<hr/>

Hibernate @EmbeddedId yoki @IdClass bo'lsin, primary key classidagi @ManyToOne assotsiatsiyasini to'g'ridan-to'g'ri
modellashni qo'llab-quvvatlaydi.
