# AttributeConverter

With a custom AttributeConverter, the application developer can map a given JDBC type to an entity basic type.

In the following example, the java.time.Period is going to be mapped to a VARCHAR database column.

```java
@Converter
public class GenderConverter implements AttributeConverter<Gender, Character> {

    @Override
    public Character convertToDatabaseColumn(Gender gender) {
        Objects.requireNonNull(gender, "gender must be not null!");
        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character character) {
        Objects.requireNonNull(character, "character must be not null!");
        return Gender.fromCode(character);
    }

}
```

Entity using the custom `Gender` AttributeConverter mapping

```java
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Convert(converter = GenderConverter.class)
    private Gender gender;
}
```

<hr/>

AttributeConverter ma'lum bir Java Objectni JDBC typega map qilish yani o'zgartirish uchun ishlatiladi.
JPA Provider tomonidan convertToDatabaseColumn method INSERT yoki UPDATE bayonatini bajarishdan oldin chaqiriladi.
convertToDatabaseColumn method Object attributeni oladi va tegishli jadval columiga o'rnatilishi kerak bo'lgan qiymatni qaytaradi.

AttributeConverter dan biz ma'lum bir data typimizni databasedagi column moslashtirishimiz uchun foydalanamiz.
Ushbu tepadgi kodda `Gender` enum converter database char qilib saqlaydi databasedan o'qiyotganda esa `Gender` enum
aylantiradi. Convert qilmoqchi bo'lgan fieldimizga `@Converter` annotatsiyasini qo'shimiz kerak.