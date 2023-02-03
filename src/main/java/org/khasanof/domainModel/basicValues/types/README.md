# Types

## ENUMS

Hibernate supports the mapping of Java enums as basic value types in a number of different ways.

`@Enumerated`
<br/>
The original Jakarta Persistence-compliant way to map enums was via the `@Enumerated` or `@MapKeyEnumerated`
annotations, working on the principle that the enum values are stored according to one of 2 strategies
indicated by `jakarta.persistence.EnumType:`

+ `ORDINAL` <br/>
  stored according to the enum value’s ordinal position within the enum class, as indicated by `java.lang.Enum#ordinal`
+ `STRING` <br/>
  stored according to the enum value’s name, as indicated by `java.lang.Enum#string`

<hr/>

Hibernate Java enumlarni databasega map qilishni turli xil usullarni qo'llab quvvatlaydi.
`@Enumerated` yoki `@MapKeyEnumerated `annotatsiyalaridan birdan foydalanib enum qiymatlarni saqlashimiz mumkin.
EnumType orqali Enum typelarni 2xil ko'rinishda SQL databaselarga saqlashimiz mumkin.

+ `ORDINAL` <br/>
  Enum ni ORDINAL typeda databasega saqlaganimizda enumlar yozilgan tartibda 0 dan boshlab belgilanadi.
+ `STRING` <br/>
  databasega enumlarni string ko'rinishda saqlab ketadi

## BLOB and CLOB

+ BLOB - Stores any kind of data in binary format. Typically used for multimedia files such as images and videos.
+ CLOB - Used for large strings or documents that use the database character set exclusively.
+ NCLOB - Stores string data in National Character Set format.

<hr/>

+ BLOB - data type har qanday ma'lumotlarni binary formatda saqlaydi. Odat Rasm va Video kabi filelar saqlash uchun
  ishlatiladi.
+ CLOB - data type katta stringlarni yoki documentlarni saqlash uchun ishlatiladi.
+ NCLOB - data type National characterlardan iborat stringlarni saqlaydi.

###           

@Temporal annotatsiyasi Time, Date, Timestamp classlarni SQL typega aylantirish uchun ishlatiladi.

## Boolean

By default, `Boolean` attributes map to `BOOLEAN` columns, at least when the database has a dedicated `BOOLEAN` type. On
databases which don’t, Hibernate uses whatever else is available: `BIT`, `TINYINT`, or `SMALLINT`.

```java
// boolean typeni hibernate databasega BIT yoki BOOLEAN ko'rinishida saqlaydi.
@Basic
boolean implicit;
```

## Byte

By default, Hibernate maps values of `Byte` / `byte` to the `TINYINT` JDBC type.

```java
// Hibernate Byte/byte JDBC TINYINT typega aylantirib saqlab ketadi.
Byte wrapperByte;
byte primitiveByte;
```

## Short

By default, Hibernate maps values of `Short` / `short` to the `SMALLINT` JDBC type.

```java
// Hibernate Short/short JDBC SMALLINT typega aylantirib saqlab ketadi.
Short wrapperShort;
short primitiveShort;
```

## Integer

By default, Hibernate maps values of `Integer` / `int` to the `INTEGER` JDBC type.

```java
// Hibernate Integer/int JDBC INTEGER typega aylantiribi saqlab ketadi.
Integer wrapperInteger;
int primitiveInteger;
```

## Long

By default, Hibernate maps values of `Long` / `long` to the `BIGINT` JDBC type.

```java
// Hibernate Long/long JDBC BIGINT typega aylantirib saqlab ketadi.
Long wrapperLong;
long primitiveLong;
```

## BigInteger

By default, Hibernate maps values of `BigInteger` to the `NUMERIC` JDBC type.

```java
// Hibernate BigInteger JDBC NUMERIC typega aylantirib saqlab ketadi.
BigInteger bigInteger;
```

## Double

By default, Hibernate maps values of `Double` to the `DOUBLE`, `FLOAT`, `REAL` or `NUMERIC` JDBC type depending on the
capabilities of the database

```java
// Hibernate Double/double JDBC DOUBLE, FLOAT, REAl yoki NUMERIC lardan biriga aylantirib saqlab ketadi.
Double wrapperDouble;
double primitiveDouble;
```

A specific type can be influenced using any of the JDBC type influencers covered in [basic-mapping-explicit] section.

If `@JdbcTypeCode` is used, the Dialect is still consulted to make sure the database supports the requested type. If not,
an appropriate type is selected

## Float

By default, Hibernate maps values of `Float` to the `FLOAT`, `REAL` or `NUMERIC` JDBC type depending on the capabilities of the
database.

```java
// Hibernate Float/float JDBC FLOAT, REAL yoki NUMERIC lardan biriga aylantirib saqlab ketadi.
Float wrapperFloat;
float primitiveFloat;
```

## BigDecimal

By default, Hibernate maps values of `BigDecimal` to the `NUMERIC` JDBC type.

```java
// BigDecimal JDBC NUMERIC ga aylantirib saqlab ketadi. 
BigDecimal bigDecimal;
```

## Character

By default, Hibernate maps `Character` to the `CHAR` JDBC type.

```java
// Character JDBC CHAR ga aylantirib saqlab ketadi.
Character wrapperCharacter;
char primitiveCharacter;
```

## String

By default, Hibernate maps `String` to the `VARCHAR` JDBC type.

```java
// String JDBC VARCHAR aylantirib saqlab ketadi.
String string;

// @Lob annotatsiyasi qo'yilgan bo'lsa Stringni JDBC CLOB aylantirib saqlab ketadi.
@Lob
String clobString;
```

Optionally, you may specify the maximum length of the string using `@Column(length=…)`, or using the `@Size` annotation
from Hibernate Validator. For very large strings, you can use one of the constant values defined by the class
org.hibernate.Length, for example:

```java
@Column(length = Length.LONG)
private String text;
```

Alternatively, you may explicitly specify the JDBC type `LONGVARCHAR`, which is treated as a `VARCHAR` mapping with
default `length=Length.LONG` when no `length` is explicitly specified:

```java
@JdbcTypeCode(Types.LONGVARCHAR)
private String text;
```

If you use Hibernate for schema generation, Hibernate will generate DDL with a column type that is large enough to
accommodate the maximum length you’ve specified.

## Character Array

By default, Hibernate maps `Character[]` and `char[]` to the VARCHAR JDBC type.

```java
// Hibernate Character[]/char[] JDBC VARCHAR ga aylantirib saqlab ketadi.
// @Lob annotatsiyasidan foydalangan holda CLOB aylantirib saqlab ketishimiz mumkin.
Character[]wrapperCharSequence;
char[]primitiveCharSequence;
```

## Byte Array

By default, Hibernate maps values of type `byte[]` and `Byte[]` to the JDBC type `VARBINARY`.

```java
 /*
   Hibernate Byte[]/byte[] JDBC VARBINARY typega aylantirib saqlab ketadi.
 */
private Byte[]primitiveByteSequence;
private byte[]wrapperByteSequence;
```

```java
/*
   Hibernate Byte[]/byte[] JDBC (materialized) BLOB typega aylantirib saqlab ketadi.

   Large Objects - (LOB) type katta hajmdagi ma'lumotlarni saqlash uchun mo'ljallangan.
   LOB - data type databaseni konfiguratsiyasiga qarab terabaytgacha bo'lishi mumkin.
*/
@Lob
private Byte[]primitiveByteLob;
@Lob
private byte[]wrapperByteLob;
```

## Duration

By default, Hibernate will map `Duration` to the `INTERVAL_SECOND` SQL type and fallback to `NUMERIC` if necessary.

```java
/*
  Duration data type Hibernate INTERVAL_SECOND SQL type o'tkazib saqlab ketadi.
  Kerak bo'lganda NUMERIC typega qaytaradi.
*/
private Duration duration;
```

## Instant

`Instant` is mapped to the `TIMESTAMP_UTC` SQL type.

```java
/*
  Hibernate Instant classlarni TIMESTAMP ga aylantirib saqlab ketadi.
*/
private Instant instant;
```

## LocalDate

`LocalDate` is mapped to the `DATE` JDBC type.

```java
/*
  Hibernate LocalDate classini DATE ga aylantirib saqlab ketadi.
*/
private LocalDate date;
```

## LocalDateTime

`LocalDateTime` is mapped to the `TIMESTAMP` JDBC type.

```java
/*
  Hibernate LocalDateTime classlarni TIMESTAMP ga aylantirib saqlab ketadi.
*/
private LocalDateTime localDateTime;
```

## LocalTime

`LocalTime` is mapped to the `TIME` JDBC type.

```java
/*
  Hibernate LocalTime classini TIME ga aylantirib saqlab ketadi.
*/
private LocalTime localTime;
```

## OffsetDateTime

`OffsetDateTime` is mapped to the `TIMESTAMP` or `TIMESTAMP_WITH_TIMEZONE` JDBC type depending on the database.

```java
/*
  Hibernate OffsetDateTime classni TIMESTAMP yoki TIMESTAMP_WITH_TIMEZONE ga aylantirib saqlab ketadi.
*/
private OffsetDateTime offsetDateTime;
```

## OffsetTime

`OffsetTime` is mapped to the `TIME` or `TIME_WITH_TIMEZONE` JDBC type depending on the database.

```java
/*
  Hibernate OffsetTime classini TIME yoki TIME_WITH_TIMEZONE ga aylantirib saqlab ketadi.
*/
private OffsetTime offsetTime;
```

## TimeZone

`TimeZone` is mapped to `VARCHAR` JDBC type.

```java
/*
  Hibernate TimeZone classini VARCHAR ga aylantirib saqlab ketadi.
*/
private TimeZone timeZone;
```

## ZonedDateTime

`ZonedDateTime` is mapped to the `TIMESTAMP` or `TIMESTAMP_WITH_TIMEZONE` JDBC type depending on the database.

```java
/*
  Hibernate ZonedDateTime classini TIMESTAMP yoki TIMESTAMP_WITH_TIMEZONE ga aylantirib saqlab ketadi.
*/
private ZonedDateTime zonedDateTime;
```

## ZonedOffset

`ZoneOffset` is mapped to `VARCHAR` JDBC type.

```java
/*
  Hibernate ZoneOffset classini VARCHAR ga aylantirib saqlab ketadi.
*/
private ZoneOffset zoneOffset;
```

## Varchar classes

Hibernate maps `Class`, `Currency` and `Locale` references to `VARCHAR` JDBC type

```java
/*
  Ushbu pastda e'lon qilingan 3ta classlarni Hibernate VARCHAR ga aylantirib saqlab ketadi.
*/
private Class<?> clazz;
private Currency currency;
private Locale locale;
```

## UUID

Hibernate allows mapping UUID values in a number of ways. By default, Hibernate will store UUID values in the native
form by using the SQL type `UUID` or in binary form with the `BINARY` JDBC type if the database does not have a native
UUID
type.

```java
/*
  UUID Hibernate databasegayam UUID qilib saqlab ketadi.
*/
private UUID uuid;
```

## InetAddress

By default, Hibernate will map `InetAddress` to the `INET` SQL type and fallback to `BINARY` if necessary.

```java
/*
  Hibernate InetAddress classini INET typega aylantirib saqlab ketadi.
*/
private InetAddress address;
```

## JSON

Hibernate will only use the `JSON` type if explicitly configured through `@JdbcTypeCode( SqlTypes.JSON )`. The JSON
library
used for serialization/deserialization is detected automatically, but can be overridden by setting
`hibernate.type.json_format_mapper` as can be read in the Configurations section.

```java
/*
  Hibernate Ushbu Mapni JSON typega aylantirib saqlab ketadi.
*/
@JdbcTypeCode(SqlTypes.JSON)
private Map<String, String> payload;
```

## Array

Basic collections (only subtypes of `Collection`), which are not annotated with `@ElementCollection`, map to the type code
`SqlTypes.ARRAY` by default, which maps to the SQL standard `array` type if possible, as determined via the new methods
`getArrayTypeName` and `supportsStandardArrays` of `org.hibernate.dialect.Dialect`. If SQL standard array types are not
available, data will be modeled as `SqlTypes.JSON`, `SqlTypes.XML` or `SqlTypes.VARBINARY`, depending on the database support
as determined via the new method `org.hibernate.dialect.Dialect.getPreferredSqlTypeCodeForArray`.

```java
/*
  Hibernate Collection classni subclasslarni ARRAY typega aylantirib saqlab ketadi.
*/
private List<Short> list;
private SortedSet<Short> sortedSet;
```