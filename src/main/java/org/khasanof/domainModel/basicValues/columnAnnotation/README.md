# Column Annotation

Jakarta Persistence defines rules for implicitly determining the name of tables and columns. For a detailed discussion of implicit naming see Naming strategies.

For basic type attributes, the implicit naming rule is that the column name is the same as the attribute name. If that implicit naming rule does not meet your requirements, you can explicitly tell Hibernate (and other providers) the column name to use.

```java
@Entity
@Table(name = "car", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true, length = 11)
    private int id;

    @Column(name = "model", nullable = false, length = 120, columnDefinition = "varchar(255) defaults 'BMW M4'")
    private String model;

    @Column(name = "price", nullable = false, length = 10, columnDefinition = "integer defaults 120000")
    private Long price;
    
    // Getters and Setters
}
```

<hr/>

@Column annotatsiyasidan foydalangan holda biz Tabledagi columni nomi o'zgartirishimiz, 
uni valuesi unique bo'lishini belgilashimiz, null bo'lishi mumkin yoki yoqligini belgilashimiz, uni length belgilashimiz,
hatto default valuesini berishimiz mumkin va h.k.z