# OneToOne Association

The @OneToOne association can either be unidirectional or bidirectional.
Let's suppose we are building a user management system, and our boss asks us to store a mailing address for each user. A
user will have one mailing address, and a mailing address will have only one user tied to it.

This is an example of a one-to-one relationship, in this case between user and address entities.

<hr/>

OneToOne association bir tomonlama yoki ikki tomonlama bo'lishi mumkin. OneToOne assosatsiyasi entity o'rtasida yakkama
yakka munosabatlarni ifodalash uchun ishlatiladi. Aytaylik, biz foydalanuvchilarni boshqarish tizimini qurmoqdamiz va
xo'jayinimiz bizdan har bir foydalanuvchi uchun pochta manzilini saqlashimizni so'raydi. Foydalanuvchi bitta pochta
manziliga ega bo'ladi va pochta manzilida faqat bitta foydalanuvchi bog'langan bo'ladi.

Bu foydalanuvchi va manzil entitylari o'rtasidagi yakkama-yakka munosabatlarga misoldir.

```java
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oto_phone_en", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTOUniPhoneEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    public Integer id;

    @Column(name = "number", nullable = false, updatable = false)
    private String number;

    @OneToOne
    @JoinColumn(name = "details_id")
    private OTOUniPhoneDetailsEntity details;

    // ...
}
```

```java
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oto_phone_details_entity", schema = "association", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class OTOUniPhoneDetailsEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "technology", nullable = false)
    private String technology;
    
    // ...
}
```