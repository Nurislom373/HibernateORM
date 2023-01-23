# Formula Annotation

@Formula allows mapping any database computed value as a virtual read-only column.

The @Formula annotation takes a native SQL clause which may affect database portability.

@Formula is a Hibernate-specific mapping construct and not covered by Jakarta Persistence. Applications interested in portability should avoid its use.

`@Formula` mapping usage

```java
@Entity
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "credit", nullable = false)
    private Double credit;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Formula(value = "credit * rate")
    private Double interest;
    
    // Getters and Setters
}
```

When loading the Account entity, Hibernate is going to calculate the interest property using the configured @Formula:

Persisting an entity with a `@Formula` mapping
```java
doInJPA(this::entityManagerFactory, entityManager -> {
	Account account = new Account();
	account.setId(1L);
	account.setCredit(5000d);
	account.setRate(1.25 / 100);
	entityManager.persist(account);
});

doInJPA(this::entityManagerFactory, entityManager -> {
	Account account = entityManager.find(Account.class, 1L);
	assertEquals(Double.valueOf(62.5d), account.getInterest());
});
```

```postgresql
INSERT INTO Account (credit, rate, id)
VALUES (5000.0, 0.0125, 1);

SELECT
    a.id as id1_0_0_,
    a.credit as credit2_0_0_,
    a.rate as rate3_0_0_,
    a.credit * a.rate as formula0_0_
FROM
    Account a
WHERE
    a.id = 1;
```

<hr/>

@Formula annotatsiya bizga databasedan malumotni o'qiygan paytda value sifatida berilgan native SQLni bajaradi.
Masalan: auth_user classimiz bor uni dateOfBirth field mavjud `@Formula` annotatsiyasidan foydalangan holda biz 
age nomli fieldni toldirib olishimiz mumkin.

