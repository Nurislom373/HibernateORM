# Basic Annotation

Strictly speaking, a basic type is denoted by the `jakarta.persistence.Basic` annotation.

Generally, the @Basic annotation can be ignored as it is assumed by default. Both of the following examples are ultimately the same.

`@Basic` explicit
```java
@Entity
@Table(name = "product", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String description;
    
    // Getter and Setters
}
```

The `@Basic` annotation defines 2 attributes.

`optional` - boolean (defaults to true) <br/>
Defines whether this attribute allows nulls. Jakarta Persistence defines this as "a hint", 
which means the provider is free to ignore it. Jakarta Persistence also says that it will be 
ignored if the type is primitive. As long as the type is not primitive, Hibernate will honor this value.
Works in conjunction with @Column#nullable - see @Column.

`fetch` - FetchType (defaults to EAGER) <br/>
Defines whether this attribute should be fetched eagerly or lazily. EAGER indicates that the
value will be fetched as part of loading the owner. LAZY values are fetched only when the value
is accessed. Jakarta Persistence requires providers to support EAGER, while support for LAZY is 
optional meaning that a provider is free to not support it. Hibernate supports lazy loading of
basic values as long as you are using its bytecode enhancement support.

<hr/>

Basic Annotatsiyasi 2ta atributni o'z ichiga oladi.

- `optional` - boolean (defaults to true)
  Ushbu atribut nulllarga ruxsat beradimi yoki yo'qligini aniqlaydi.

- `fetch` - FetchType (defaults to EAGER)
  Bu atribut qiymatni EAGER yoki LAZY olish kerakligini aniqlaydi.