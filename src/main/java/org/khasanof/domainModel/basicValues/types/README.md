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

+ BLOB - data type har qanday ma'lumotlarni binary formatda saqlaydi. Odat Rasm va Video kabi filelar saqlash uchun ishlatiladi.
+ CLOB - data type katta stringlarni yoki documentlarni saqlash uchun ishlatiladi.
+ NCLOB - data type National characterlardan iborat stringlarni saqlaydi.

### 

@Temporal annotatsiyasi Time, Date, Timestamp classlarni SQL typega aylantirish uchun ishlatiladi.