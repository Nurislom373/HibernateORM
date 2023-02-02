# OneToMany Association

Simply put, one-to-many mapping means that one row in a table is mapped to multiple rows in another table.

The @OneToMany association links a parent entity with one or more child entities. If the @OneToMany doesn’t have a
mirroring @ManyToOne association on the child side, the @OneToMany association is unidirectional. If there is a
@ManyToOne association on the child side, the @OneToMany association is bidirectional and the application developer can
navigate this relationship from both ends.

<hr/>

One-to-many tabledagi bitta row boshqa bir tabledagi bir nechta rowlarga bog'langanligini anglatadi.
Misol uchun: Bitta personda bir nechta telefonlar bo'lishi mumkin. 

@OneToMany assotsiatyasi parent entityni bir yoki bir nechta child entitylar bilan bog'laydi. Agar @OneToMany ning
child tomonida aks ettiruvchi @ManyToOne assosatsiyasi bo'lmasa, @OneToMany assosatsiyasi bir tomonlama bo'ladi.
Agar child entity tomonida @ManyToOne mavjud bo'lsa ikki tomonlama bo'ladi va Developer bu aloqani har ikki tomondan
boshqarishi mumkin.

```java
@Entity(name = "otm_phone")
@Table(name = "otm_phone", schema = "association")
public class OTMPhone {

    @Id
    @GeneratedValue
    private Integer id;

    private String number;

    // ...
}
```

```java
@Entity(name = "otm_person")
@Table(name = "otm_person", schema = "association")
public class OTMPerson {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OTMPhone> phones;

    // ...
}
```