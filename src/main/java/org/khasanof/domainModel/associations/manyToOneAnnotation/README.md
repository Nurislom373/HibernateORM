# @ManyToOne Annotation

The @ManyToOne relationship is the most common JPA association and it maps exactly to the oneto-many table relationship.
When using a @ManyToOne association, the underlying foreign key is controlled by the child-side, no matter the
association is unidirectional or bidirectional.

we can specify a many-to-one relationship by using the @ManyToOne annotation. A many-to-one mapping means that many
instances of this entity are mapped to one instance of another entity – many items in one cart.

<hr/>

@ManyToOne munosabatlari(relationship) eng keng tarqalgan JPA assotsiatsiyasi bo'lib, u one-to-many table
munosabatlariga to'liq mos keladi. @ManyToOne assotsiatsiyasidan foydalanilganda, assotsiatsiya bir tomonlama yoki ikki
tomonlama bo'lishidan qat'i nazar, foreign key bolalar tomonidan boshqariladi.

@ManyToOne annotatsiyasidan foydalanib many-to-one munosabatni belgilashimiz mumkin.
Many-to-one shuni anglatadiki, bu entityning ko'p nusxalari boshqa entityning bitta nusxasiga bog'langan.
Misol uchun: bir nechta telefon raqamlari bitta odam tegishli.

```java

@Entity
@Table(name = "mto_person", schema = "association")
public class MTOPerson {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    // ...
}
```

```java

@Entity
@Table(name = "mto_phone", schema = "association")
public class MTOPhone {

    @Id
    @GeneratedValue
    private Integer id;

    private String number;

    // ...
}
```

When you model your database, you will most likely define several many-to-one or one-to-many associations. And it’s, of
course, the same when you model your entities. It’s quite easy to do that with JPA and Hibernate. You just need an
attribute that represents the association and annotate it with a @ManyToOne or @OneToMany association. But as easy as it
seems, there are several pitfalls that you can avoid by following a few best practices.