# Generated Properties

## @GeneratedUuidValue

Hibernate also supports value generation via a pluggable API using @ValueGenerationType and AnnotationValueGeneration 
allowing users to define any generation strategy they wish.

Let’s look at an example of generating UUID values. First the attribute mapping

## @UpdateTimestamp

The `@UpdateTimestamp` annotation is an in-VM INSERT strategy.
Hibernate will use the current timestamp of the JVM as the insert and update value for the attribute.

Supports most temporal types (java.time.Instant, java.util.Date, java.util.Calendar, etc)

<hr/>

Ushbu annotatsiya INSERT va UPDATE bo'lganda VMdan hozirgi vaqt oladi va yozadi. Hozirgi vaqtni time zone boyicha oladi.
Ushbu annotatsiyani (`java.time.Instant`, `java.util.Date`, `java.util.Calendar` va etc.)
classlar bilan ishlatishimiz mumkin.

## @CreationTimestamp

The @CreationTimestamp annotation is an in-VM INSERT strategy. Hibernate will use the current timestamp of the JVM as the insert value for the attribute.

Supports most temporal types (java.time.Instant, java.util.Date, java.util.Calendar, etc)

While inserting the Event, Hibernate will populate the underlying timestamp column with the current JVM timestamp value

<hr/>

@CreationTimestamp annotatsiyasi faqat INSERT bo'lgandagina hozirgi vaqtni VM olib yozadi.
Ushbu annotatsiyani (`java.time.Instant`, `java.util.Date`, `java.util.Calendar` va etc.) 
classlar bilan ishlatishimiz mumkin. 

!Ushbu annotatsiyani time zonedagi current vaqt oladi.

## @CurrentTimestamp

Hibernate supports both in-VM and in-DB generation. A generation that uses the current JVM timestamp as the generated 
value is an example of an in-VM strategy. A generation that uses the database’s current_timestamp function is an
example of an in-DB strategy.

+ `GenerationTiming.NEVER` (the default) <br/> the given attribute value is not generated
+ `GenerationTiming.INSERT` - the attribute value is generated on insert but is not regenerated on subsequent updates
+ `GenerationTiming.ALWAYS` - the attribute value is generated both on insert and update.

<hr/>

@CurrentTimestamp databasening current_timestamp funksiyasidan foydalangan holda hozirgi vaqtni strategiyasiga
qarab INSRET yoki UPDATE qiladi.

+ `GenerationTiming.NEVER` - hech qanday INSERT yoki UPDATE qilmaydi. @CurrentTimestamp defualt ushbu startegiyadan foydalanadi.
+ `GenerationTiming.INSERT` - INSERT bo'lgandagina hozi vaqt yozadi.
+ `GenerationTiming.ALWAYS` - INSERT hamda UPDATE bo'lganda hozirgi vaqt yozadi.

