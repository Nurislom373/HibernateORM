# @NaturalId Annotation

Natural ids represent domain model unique identifiers that have a meaning in the real world too. Even if a natural id
does not make a good primary key (surrogate keys being usually preferred), it’s still useful to tell Hibernate about it.
As we will see later, Hibernate provides a dedicated, efficient API for loading an entity by its natural id much like it
offers for loading by its identifier (PK).

<hr/>

Biz @NatrualId annotatsiya orqali entity istalgan fieldni unique qilib belgilash uchun ishlatamiz. Hibernate orqali
@NaturalId annotatsiyasi qo'yilgan field orqali databasedan select qilishimiz mumkin.

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
	.using("isbn", "978-9730228236")
	.load();
```

```java
Book book = entityManager
	.unwrap(Session.class)
	.byNaturalId(Book.class)
	.using(
		"isbn",
		new Isbn("973022823X", "978-9730228236"))
	.load();
```

```java
Book book = entityManager
	.unwrap(Session.class)
	.byNaturalId(Book.class)
	.using("productNumber", "973022823X")
	.using("publisher", publisher)
	.load();
```

- `load()` <br/>
  obtains a reference to the entity, making sure that the entity state is initialized.
- `getReference()` <br/>
  obtains a reference to the entity. The state may or may not be initialized. If the entity is already associated with 
  the current running Session, that reference (loaded or not) is returned. If the entity is not loaded in the current 
  Session and the entity supports proxy generation, an uninitialized proxy is generated and returned, otherwise the 
  entity is loaded from the database and returned.