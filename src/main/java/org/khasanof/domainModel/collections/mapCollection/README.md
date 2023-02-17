# Map Collection

## Maps Are Different from Lists

Using a Map to represent a one-to-many relationship is different from a List because we have a key.

This key turns our entity relationship into a ternary association, where each key refers to a simple value or an
embeddable object or an entity. Because of this, to use a Map, we'll always need a join table to store the foreign key
that references the parent entity – the key, and the value.

But this join table will be a bit different from other join tables in that the primary key won't necessarily be foreign
keys to the parent and the target. Instead, we'll have the primary key be a composite of a foreign key to the parent and
a column that is the key to our Map.

<hr/>

Hibernateda biz one-to-many relationshipni Collection orqali ifodalashimiz mumkin. One-to-many munosabatni ifodalash
uchun _Map_ dan foydalanish _List_ farq qiladi, sababi Map key bor.

Ushbu Key bizning entity munosabatlarimizni ternary assosiatsiyaga aylantiradi. Ushbu Key oddiy type, embeddable yoki
entity bo'lishi mumkin.

## @MapKeyColumn

Let's say we have an Order entity and we want to keep track of name and price of all the items in an order. So, we want
to introduce a Map<String, Double> to Order which will map the item's name to its price:

<hr/>

Aytaylik, bizda Order entitysi bor va biz orderdagi barcha elementlarning nomi va narxini kuzatib borishni
xohlaymiz. Shunday qilib, biz buyum nomini uning narxiga moslashtiradigan Map<String, Double> to Order ni taqdim
qilmoqchimiz:

```java

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "map_order", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MAPOrder {

    @Id
    @GeneratedValue
    private Integer id;

    @ElementCollection
    @CollectionTable(
            name = "item_price_mapping",
            schema = "collections",
            joinColumns = {
                    @JoinColumn(name = "order_id", referencedColumnName = "id")
            }
    )
    @MapKeyJoinColumn(name = "item_name")
    @Column(name = "price")
    private Map<String, Double> itemPriceMap;
}
```

We need to indicate to Hibernate where to get the key and the value. For the key, we've used @MapKeyColumn, indicating
that the Map‘s key is the item_name column of our join table, order_item_mapping. Similarly, @Column specifies that the
Map's value corresponds to the price column of the join table.

Also, itemPriceMap object is a value type map, thus we must use the @ElementCollection annotation.

In addition to basic value type objects, @Embeddable objects can also be used as the Map‘s values in a similar fashion.

<hr/>

Biz Hibernatega key-value ni qayerdan olishni ko'rsatishimiz kerak. Key belgilash uchun @MapKeyColumn annotatsiyasidan
foydalandik, Bu Map-ning key tablelar join bo'lganda item_name column ekanligi belgilash uchun, Xuddi shunday @Column
Map ni value belgilash uchun ishlatamiz.

itemPriceMap atributni Map type qilib belgilashimiz uchun @ElementCollection-dan foydalandik.

@ElementCollection more info - [link](../elementCollection/README.md)

## @MapKey

Hammamizga ma'lumki, talablar vaqt o'tishi bilan o'zgaradi - deylik, biz Itemning yana bir qancha atributlarini itemName
va itemPrice bilan birga saqlashimiz kerak :

```java

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "map_item", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MapItem {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String itemName;

    @Column(name = "price")
    private double itemPrice;

    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private MapItemType itemType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;
}
```

```java

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "map_sec_order", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class MapSecOrder {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_item_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")}
    )
    @MapKey(name = "itemName")
    private Map<String, MapItem> itemMap;
}
```

Note that this time, we'll use the @MapKey annotation so that Hibernate will use Item#itemName as the map key column
instead of introducing an additional column in the join table. So, in this case, the join table order_item_mapping
doesn't have a key column — instead, it refers to the Item‘s name.

This is in contrast to @MapKeyColumn. When we use @MapKeyColumn, the map key resides in the join table. This is the
reason why we can't define our entity mapping using both the annotations in conjunction.

Also, itemMap is an entity type map, therefore we have to annotate the relationship using @OneToMany or @ManyToMany.

## Using @MapKeyEnumerated and @MapKeyTemporal

Whenever we specify an enum as the Map key, we use @MapKeyEnumerated. Similarly, for temporal values, @MapKeyTemporal is
used. The behavior is quite similar to the standard @Enumerated and @Temporal annotations respectively.

By default, these are similar to @MapKeyColumn in that a key column will be created in the join table. If we want to
reuse the value already stored in the persisted entity, we should additionally mark the field with @MapKey.

## Using @MapKeyJoinColumn

We need to add @MapKeyJoinColumn to achieve this since that annotation allows Hibernate to keep the seller_id column (
the map key) in the join table order_item_mapping along with the item_id column. So then, at the time of reading the
data from the database, we can perform a GROUP BY operation easily.
