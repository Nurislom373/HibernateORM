# ListArrayType

Because Hibernate ORM does not support ARRAY column types, we need to use the Hypersistence Utils open-source project to
be able to map PostgreSQL ARRAY columns to Java List entity attributes.

<hr/>

Biz Entity atributni ya'ni Collectionlari databaseda Arraya qilib saqlashimiz uchun Hypersistence Utils Projectidan
foydalanamiz. Hibernate ORM Array columnlarni qo'llab quvvatlamasligi sababli Javadagi List objectni Array qilib
saqlashimiz uchun Hypersistence Utils dan foydalanamiz.

```java
@Entity(name = "Event")
@Table(name = "event", schema = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Type(value = ListArrayType.class)
    @Column(
            name = "sensor_ids",
            columnDefinition = "uuid[]"
    )
    private List<UUID> sensorIds;

    @Type(ListArrayType.class)
    @Column(
            name = "sensor_names",
            columnDefinition = "text[]"
    )
    private List<String> sensorNames;

    @Type(ListArrayType.class)
    @Column(
            name = "sensor_values",
            columnDefinition = "integer[]"
    )
    private List<Integer> sensorValues;

    @Type(value = ListArrayType.class)
    @Column(
            name = "sensor_long_values",
            columnDefinition = "bigint[]"
    )
    private List<Long> sensorLongValues;

    @Type(ListArrayType.class)
    @Column(
            name = "date_values",
            columnDefinition = "date[]"
    )
    private List<Date> dateValues;

    @Type(ListArrayType.class)
    @Column(
            name = "timestamp_values",
            columnDefinition = "timestamp[]"
    )
    private List<Date> timestampValues;
}
```