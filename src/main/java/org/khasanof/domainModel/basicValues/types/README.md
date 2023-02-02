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

By default, Boolean attributes map to BOOLEAN columns, at least when the database has a dedicated BOOLEAN type. On
databases which don’t, Hibernate uses whatever else is available: BIT, TINYINT, or SMALLINT.

```java
// boolean typeni hibernate databasega BIT yoki BOOLEAN ko'rinishida saqlaydi.
@Basic
boolean implicit;
```

## Byte

By default, Hibernate maps values of Byte / byte to the TINYINT JDBC type.

```java
// Hibernate Byte/byte JDBC TINYINT typega aylantirib saqlab ketadi.
private Byte wrapperByte;
private byte primitiveByte;
```

## Short

By default, Hibernate maps values of Short / short to the SMALLINT JDBC type.

```java
// Hibernate Short/short JDBC SMALLINT typega aylantirib saqlab ketadi.
private Short wrapperShort;
private short primitiveShort;
```

## Integer

## Long

## BigInteger

## Double

## Float

## BigDecimal

## Character

## String

## Character Array

## Byte Array

## Duration

## Instant/LocalDateTime

## LocalDate

## LocalTime

## OffsetDateTime

## OffsetTime

## TimeZone

## ZonedDateTime 

## ZonedOffset

## Varchar classes

## UUID

## InetAddress 

## JSON

## Array