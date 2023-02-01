# @OrderBy Annotation

Hibernate uses the value of the annotation to create an ORDER BY statement when it fetches the related entities from the
database.

The annotation @OrderBy Specifies the ordering of the elements of a collection valued association or element collection
at the point when the association or collection is retrieved.

<hr/>

@OrderBy annotatsiyasini nomidan ko'rinib turibdiku bir biri bilan bog'langan entitylarni order qilib olish uchun
ishlatamiz. Asosan ushbu annotatsiyani collectionlar bilan ishlatamiz.

```java

@Entity(name = "ob_book")
public class OBBook {

    @Id
    private Integer id;

    private String name;

    // ...
}
```

```java

@Entity(name = "ob_author")
public class OBAuthor {

    @Id
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(name = "ob_book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    @OrderBy(value = "name ASC")
    private List<OBBook> books;

    // ...
}
```