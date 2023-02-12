# @NotFound Annotation

@NotFound in hibernate is used when entities are associated to each other by ManyToOne, OneToMany etc. Suppose joined
subclass has no data related to any id due to some database inconsistency. And we do not want to throw error, in this
case @NotFound helps us. If we use @NotFound, then for any id if there is no data in associated joined subclass, error
will not be thrown. @NotFound has two action NotFoundAction.IGNORE and NotFoundAction.EXCEPTION.

Hibernate is not going to throw any exception, and it will assign a value of null for the non-existing City entity
reference.

<hr/>

Hibernate @NotFound annotatsiyasi entitylari o'rtasidagi associatsiyalar bilan bir ishlashtamiz Many-to-one, One-to-one.
Aytaylik, birlashtirilgan kichik sinfda ma'lumotlar bazasi nomuvofiqligi tufayli hech qanday identifikatorga tegishli
ma'lumotlar yo'q. Va biz xato qilishni xohlamaymiz, bu holda @NotFound bizga yordam beradi. Agar biz @NotFound dan
foydalansak, u holda bog'langan qo'shilgan kichik sinfda ma'lumotlar bo'lmasa, har qanday identifikator uchun xatolik
yuzaga kelmaydi. @NotFound ikkita NotFoundAction.IGNORE va NotFoundAction.EXCEPTION amallariga ega.

Ushbu annoatatsiyadan foydalansak entity boshqa bir bog'langan entity yo'q bo'lgan taqdirda null qiymatni belgilaydi.

## NotFoundAction.EXCEPTION

You can define the NotFoundAction.EXCEPTION by annotating the attribute that maps your association with @NotFound and
setting the action attribute to EXCEPTION or keeping it empty. This tells Hibernate to throw a FetchNotFoundException if
it can’t resolve the foreign key reference.

<hr/>

Agar biz `@NotFound` annotatsiyasini EXCEPTION actionidan foydalansak agar Hibernate foreign key reference topa olmasa
FetchNotFoundException tashlaydi.

```java
@Entity(name = "NFCityEntity")
@Table(name = "NFCityEntity", schema = "association")
public class NFCityEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    // ...
}
```

```java
@Entity(name = "NFPersonEntity")
@Table(name = "NFPersonEntity", schema = "association")
public class NFPersonEntity {

    @ManyToOne
    @NotFound(action = NotFoundAction.EXCEPTION)
    @JoinColumn(name = "city_fk", referencedColumnName = "id")
    private NFCityEntity city;

    // ...
}
```

This behavior might seem very similar to the one you get without annotating your association with @NotFound. But there
are 2 differences:

- Hibernate throws a _FetchNotFoundException_ instead of an _EntityNotFoundException_.
- Hibernate ignores the configured FetchType and tries to fetch the association eagerly to validate the foreign key
  reference. Due to that, Hibernate throws the _FetchNotFoundException_ when it instantiates the entity object and not
  when you use the association for the first time. This makes the _FetchNotFoundException_ a little easier to handle.

<hr/>

Ushbu annotatsiyani bilan annotatsiyasiz farq uncha sezilmasligi mumkin lekin 2ta farqi bor:

- Hibernate _EntityNotFoundException_ o'rniga _FetchNotFoundException_ tashlaydi.
- Hibernate associatsiyani FetchType ga etibor bermaydi va Hibernate foriegn key reference tekshirish uchun
  associatsiyani olishga harakat qiladi. Shu sababli Hibernate FetchNotFoundException entity yaratganda tashlaydi.

## NotFoundAction.IGNORE

Setting the NotFoundAction to IGNORE enables you to handle the broken foreign key reference in your business code.
Instead of throwing an exception if it can’t resolve the foreign key reference, Hibernate sets the association attribute
to null. Due to that, you can no longer distinguish if an association wasn’t set or if it’s referencing a record that no
longer exists. You need to decide for your application, if you want to handle these 2 cases differently. If that’s the
case, you can’t use NotFoundAction.IGNORE.

<hr/>

NotFound annotatsiyasini IGNORE actionni o'rnatsangiz foreign key reference boshqarish imkonini beradi. Hibernate
foreign key hal qila olmasa yani topa olmasa, exception tashlash o'rniga, Hibernate associatsiyani atributiga null
qiymat beradi. Shu sababli siz associatsiyani o'rnatilgan yoki yo'qligini farqlay olmaysiz.

```java
@Entity(name = "NFPersonEntity")
@Table(name = "NFPersonEntity", schema = "association")
public class NFPersonEntity {

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "city_fk", referencedColumnName = "id")
    private NFCityEntity city;

    // ...
}
```

<br/>

If you don’t annotate your association attribute with @NotFound, Hibernate expects that a foreign key constraint
validates the foreign key reference. Due to that, it only needs to check if a foreign key reference is set. If that’s
the case, it knows that it will be able to resolve the reference and initializes the entity attribute with a proxy
object. When you use that proxy for the first time, Hibernate will execute an SQL statement to resolve the foreign key
reference.

If you annotate the association attribute with @NotFound, Hibernate can no longer trust the foreign key reference.
Without a foreign key constraint, the reference might be broken. Hibernate, therefore, can’t simply use the foreign key
value to instantiate a proxy object. It first needs to check if the reference is valid. Otherwise, it would need to set
the association attribute to null.

Performing this additional query can create performance problems. But there is only a minimal performance difference
between checking the foreign key reference and trying to fetch the associated entity. Due to that, the Hibernate team
decided to use eager fetching for all associations annotated with @NotFound.

<hr/>

