# @PrimaryKeyJoinColumn Annotation

The @PrimaryKeyJoinColumn specifies the mapping of the foreign key column of a secondary table or the foreign key column
in an inheritance mapping that uses the JOINED strategy. So, the annotation you need to use depends on the context in
which you want to customize the mapping of the foreign key column.

<hr/>

Ushbu annotatsiyadan foydalanib entity bir birga bog'lasak SELECT qilayotgan paytimizda 2 ta tableni bir biriga join
qilgan holda entityni bizga beradi. Agar biz @JoinColumn foydalanganimizda foriegn key orqali 2ta table bir biriga
ulagan bo'lardik. Ushbu @PrimaryKeyJoinColumn annotatsiya esa join orqali bizga kerak entity qaytaradi.

```java

@Entity(name = "derived_pk_entity")
public class DerivedPKEntity {

    @Id
    private Long id;

    @NaturalId
    private String registrationNumber;

    // ...
}
```

```java

@Entity(name = "derived_pk_details_entity")
public class DerivedPKDetailsEntity {

    @Id
    private Long id;

    private String nickName;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    private DerivedPKEntity derivedPK;

    public void setDerivedPK(DerivedPKEntity entity) {
        this.derivedPK = entity;
        this.id = entity.getId();
    }

    // ...
}
```

Using the @JoinColumn annotation
When you add the @JoinColumn annotation to your association mapping, you can define the name of the foreign key column
that represents your association in the table model.


Using the @PrimaryKeyJoinColumn annotation
When you use the inheritance mapping strategy JOINED, all columns mapped by the superclass get mapped to one database
table, and the specific attributes of a subclass get mapped to a different table. Hibernate has to join these 2 tables,
whenever you use the subclass. The primary key columns of each table are then used as the join columns.
