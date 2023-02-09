# ManyToMany Association

Many-to-Many relationships are another often used association type. On the database level, it requires an additional
association table which contains the primary key pairs of the associated entities. But as you will see, you don’t need
to map this table to an entity.

A typical example for such a many-to-many association are Products and Stores. Each Store sells multiple Products and
each Product gets sold in multiple Stores.

Similar to the many-to-one association, you can model a many-to-many relationship as a uni- or bidirectional
relationship between two entities.

<hr/>

Many-to-many munosabatlar boshqa tez tez ishlatiladigan assotsiatsiya type. Database levelda u bog'langan entitylarning
primary keylarni o'z ichiga olgan qo'shimcha tableni talab qiladi. Lekin biz ushbu 3chi tableni entity siaftida
belgilashimiz shart emas.

Many-to-many assosatsiyalarga odiy misol - Mahsulotlar va do'konlar. Har bir do'kon bir nechta mahsulotni sotadi va har
bir mahsulot bir nechta do'konlarda sotiladi.

Many-to-many associatsiyasni 2ta entity o'rtasida bir yoki ikki tomonlama munosabatlar sifatida belgilashimiz mumkin.

## Unidirectional Many-to-Many Associations

Similar to the previously discussed mappings, the unidirectional many-to-many relationship mapping requires an entity
attribute and a @ManyToMany annotation. The attribute models the association and you can use it to navigate it in your
domain model or JPQL queries. The annotation tells Hibernate to map a many-to-many association.

Let’s take a look at the relationship mapping between a Store and a Product. The Set products attribute models the
association in the domain model and the @ManyToMany association tells Hibernate to map it as a many-to-many association.

And as I already explained, please note the difference to the previous many-to-one mappings. You should map the
associated entities to a Set instead of a List.

<hr/>

Oldin muhokama qilingan bog'lash(map)larga o'xshab, unidirectional yani bir yo'nalishli many-to-many associatsiyalarni
belgilash uchun entity atributi va @ManyToMany annotatsiyasni talab qiladi. Ushbu annotatsiyasi hibernate-ga
many-to-many associatsiyasi sifatida bog'lanishini aytadi.

```java

@Entity
public class Store {

    @ManyToMany
    private Set<Product> products = new HashSet<Product>();

    // ...
}
```

If you don’t provide any additional information, Hibernate uses its default mapping which expects an association table
with the name of both entities and the primary key attributes of both entities. In this case, Hibernate uses the
Store_Product table with the columns store_id and product_id.

You can customize that with a @JoinTable annotation and its attributes joinColumns and inverseJoinColumns. The
joinColumns attribute defines the foreign key columns for the entity on which you define the association mapping. The
inverseJoinColumns attribute specifies the foreign key columns of the associated entity.

The following code snippet shows a mapping that tells Hibernate to use the store_product table with the fk_product
column as the foreign key to the Product table and the fk_store column as the foreign key to the Store table.

<hr/>

Hech qanday qo'shimcha ma'lumot bermasangiz, Hibernate o'zning standard xaritalashidan foydalanadi. Yani hibernate
ikkala entity nomi va ikkala entitylarni primary key atributlarni bog'langan tableni kutadi. Bunday holda, Hibernate
Store_Product tableni store_id va product_id columnlari bilan yaratadi.

Biz ushbu Store_Product table @JoinTable annotatsiyasi yordamida customize yani sozlashimiz mumkin. Ushbu annotatsiyasni
joinColumns atributi entityni foreign key columnlarni belgilaydi. inverseJoinColumns atributi bog'langan entityning
forign key columnlarni belgilaydi.

```java

@Entity
public class Store {

    @ManyToMany
    @JoinTable(name = “store_product”,
            joinColumns = {@JoinColumn(name = “fk_store”)},
            inverseJoinColumns = {@JoinColumn(name = “fk_product”)})
    private Set<Product> products = new HashSet<Product>();

    // ...
}
```

## Bidirectional Many-to-Many Associations

The bidirectional relationship mapping allows you to navigate the association in both directions. And after you’ve read
the post this far, you’re probably not surprised when I tell you that the mapping follows the same concept as the
bidirectional mapping of a many-to-one relationship.

One of the two entities owns the association and provides all mapping information. The other entity just references the
association mapping so that Hibernate knows where it can get the required information.

Let’s start with the entity that owns the relationship. The mapping is identical to the unidirectional many-to-many
association mapping. You need an attribute that maps the association in your domain model and a @ManyToMany association.
If you want to adapt the default mapping, you can do that with a @JoinColumn annotation.

<hr/>

bidirectional munosabatlar associatsiyasi har ikki entityda boshqarish imkoni beradi.

Ikki entitydan biri assotsiatsiyaga egalik qiladi va barcha xaritalash ma'lumotlarini taqdim etadi. Boshqa entity faqat
assotsiatsiya xaritasiga havola qiladi, shunda Hibernate kerakli ma'lumotni qayerdan olishini biladi.

```java
public class MTMUniPostEntity {

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<MTMUniTagEntity> tags = new ArrayList<>();

    // ...
}
```

```java
public class MTMUniTagEntity {

    @ManyToMany(mappedBy = "tags")
    private List<MTMUniPostEntity> posts = new ArrayList<>();

    public MTMUniTagEntity(String name) {
        this.name = name;
    }

    // ...
}
```