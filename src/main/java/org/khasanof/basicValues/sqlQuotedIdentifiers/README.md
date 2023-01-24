# SQL Quoted Identifiers

You can force Hibernate to quote an identifier in the generated SQL by enclosing the table or column name in backticks in the mapping document. While traditionally, Hibernate used backticks for escaping SQL reserved keywords, Jakarta Persistence uses double quotes instead.

Once the reserved keywords are escaped, Hibernate will use the correct quotation style for the SQL `Dialect`. This is usually double quotes, but SQL Server uses brackets and MySQL uses backticks.

### Example Hibernate quoting

```java
@Entity(name = "Product")
public static class Product {

	@Id
	private Long id;

	@Column(name = "`name`")
	private String name;

	@Column(name = "`number`")
	private String number;

	//Getters and setters are omitted for brevity

}
```

### Example Jakarta Persistence quoting

```java
@Entity(name = "Product")
public static class Product {

	@Id
	private Long id;

	@Column(name = "\"name\"")
	private String name;

	@Column(name = "\"number\"")
	private String number;

	//Getters and setters are omitted for brevity

}
```

Because `name` and `number` are reserved words, the `Product` entity mapping uses backticks to quote these column names.

When saving the following `Product entity`, Hibernate generates the following SQL insert statement:

### Persisting a qouted column name

```java
Product product = new Product();
product.setId(1L);
product.setName("Mobile phone");
product.setNumber("123-456-7890");
entityManager.persist(product);
```

```postgresql
INSERT INTO Product ("name", "number", id)
VALUES ('Mobile phone', '123-456-7890', 1);
```

#### Global Quoting
Hibernate can also quote all identifiers (e.g. table, columns) using the following configuration property:

```xml
<property
    name="hibernate.globally_quoted_identifiers"
    value="true"
/>
```

This way, we don’t need to manually quote any identifier:

```java
@Entity(name = "Product")
public static class Product {

	@Id
	private Long id;

	private String name;

	private String number;

	//Getters and setters are omitted for brevity

}
```

When persisting a `Product` entity, Hibernate is going to quote all identifiers as in the following example:

```postgresql
INSERT INTO "Product" ("name", "number", "id")
VALUES ('Mobile phone', '123-456-7890', 1);
```

As you can see, both the table name and all the column have been quoted.