# @NaturalId Annotation

Hibernate entities have @Id annotation that marks a field primary id for that entity. But sometimes, we may have a field
in the entity that can uniquely identify the entity, but for some reason, it is not a suitable primary key.

For example, a UserEntity can have id field of long type to uniquely identify the user in that system. At the same time,
users may have an email that can also uniquely identify the user in the system. But we cannot use the email as the
primary key because it will be used as a foreign key in many other places and also in link/join tables. Using email in
these places would not make sense at all.

<hr/>

Bizga entityda _id_ boshqa yana unique identifikatori kerak bo'lishi mumkin masalan, _UserEntity_ Long typedagi _id_
field bor. Shu bilan birga UserEntity ni email ham bo'lishi mumkin. Biz ushbu fieldni ham unique identifikatori sifatida
belgilashimiz kerak.
Biz @NatrualId annotatsiya orqali entity istalgan fieldni unique identifikato qilib belgilash uchun ishlatamiz.
Hibernate sizga entitylarga to'g'ridan to'g'ri identifikatori yoki JPQL yoki SQL query orqali olish imkoni beradi.

```java
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "natural_book")
public class NaturalBook {

    @Id
    private Integer id;
    private String title;
    private String author;
    @NaturalId
    private String isbn;
}
```

Biz @NaturalId faqat oddiy typelarga emas balki embeddable classlarga nisbatan ham qo'llashimiz mumkin.

```java
@Entity(name = "Book")
public static class Book {

    @Id
    private Long id;

    private String title;

    private String author;

    @NaturalId
    @Embedded
    private Isbn isbn;

    //Getters and setters are omitted for brevity
}

@Embeddable
public static class Isbn implements Serializable {

    private String isbn10;

    private String isbn13;

    //Getters and setters are omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Isbn isbn = (Isbn) o;
        return Objects.equals(isbn10, isbn.isbn10) &&
                Objects.equals(isbn13, isbn.isbn13);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn10, isbn13);
    }
}
```

```java
@Entity(name = "Book")
public static class Book {

    @Id
    private Long id;

    private String title;

    private String author;

    @NaturalId
    private String productNumber;

    @NaturalId
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    //Getters and setters are omitted for brevity
}

@Entity(name = "Publisher")
public static class Publisher implements Serializable {

    @Id
    private Long id;

    private String name;

    //Getters and setters are omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id) &&
                Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
```

As stated before, Hibernate provides an API for loading entities by their associated natural id. This is represented by
the `org.hibernate.NaturalIdLoadAccess` contract obtained via Session#byNaturalId.

<hr/>

Natural Id orqali entitylarni load qilishimiz mumkin.

```java
Book book = entityManager
        .unwrap(Session.class)
        .byNaturalId(Book.class)
        .using("isbn","978-9730228236")
        .load();
```

```java
Book book = entityManager
        .unwrap(Session.class)
        .byNaturalId(Book.class)
        .using("isbn", new Isbn("973022823X","978-9730228236"))
        .load();
```

```java
Book book = entityManager
        .unwrap(Session.class)
        .byNaturalId(Book.class)
        .using("productNumber","973022823X")
        .using("publisher",publisher)
        .load();
```

- `load()` <br/>
  obtains a reference to the entity, making sure that the entity state is initialized.
- `getReference()` <br/>
  obtains a reference to the entity. The state may or may not be initialized. If the entity is already associated with
  the current running Session, that reference (loaded or not) is returned. If the entity is not loaded in the current
  Session and the entity supports proxy generation, an uninitialized proxy is generated and returned, otherwise the
  entity is loaded from the database and returned.

!Note <br/>
Hibernate @NaturalId annotatsiyasi qo'yilgan field default immutable bo'ladi ya'ni biz uni o'zgartira olmaymiz. Mutable
qilishimiz uchun.

```java
@Entity(name = "Author")
public static class Author {

    @Id
    private Long id;

    private String name;

    @NaturalId(mutable = true)
    private String email;

    //Getters and setters are omitted for brevity
}
```

Within the Session, Hibernate maintains a mapping from natural id values to entity identifiers (PK) values. If natural
ids values changed, it is possible for this mapping to become out of date until a flush occurs.

To work around this condition, Hibernate will attempt to discover any such pending changes and adjust them when the
load() or getReference() methods are executed. To be clear: this is only pertinent for mutable natural ids.

```java
Author author = entityManager
	.unwrap(Session.class)
	.bySimpleNaturalId(Author.class)
	.load("john@acme.com");

author.setEmail("john.doe@acme.com");

assertNull(
	entityManager
		.unwrap(Session.class)
		.bySimpleNaturalId(Author.class)
		.setSynchronizationEnabled(false)
		.load("john.doe@acme.com")
);

assertSame(author,
	entityManager
		.unwrap(Session.class)
		.bySimpleNaturalId(Author.class)
		.setSynchronizationEnabled(true)
		.load("john.doe@acme.com")
);
```