# POJO Models

The Entity Class of the Java Persistence 2.1 specification defines its requirements for an entity class. Applications
that wish to remain portable across Jakarta Persistence providers should adhere to these requirements:

+ The entity class must be annotated with the jakarta.persistence.Entity annotation (or be denoted as such in XML
  mapping).
+ The entity class must have a public or protected no-argument constructor. It may define additional constructors as
  well.
+ The entity class need not be a top-level class.
+ An enum or interface may not be designated as an entity.
+ The entity class must not be final. No methods or persistent instance variables of the entity class may be final.
+ Both abstract and concrete classes can be entities. Entities may extend non-entity classes as well as entity classes,
  and non-entity classes may extend entity classes.

<hr/>

Hibernate classlarni entitylarga aylantirish uchun bir qancha talablarni belgilaydi.

+ Class `@Entity` annotatsiya bilan qoyilgan bo'lishi kerak(yoki XML orqali belgilanishi kerak).
+ Classda public yoki protected no-arg constructor bo'lishi kerak. Qo'shimcha constructorlar bo'lishi mumkin.
+ Class top-level class bo'lishi shart emas.
+ Enum yoki Interface entity sifatida belgilab bo'lmaydi.
+ Entity aylantirmoqchi bo'lgan classimiz final bo'lmasligi kerak. Classni instance variablelar hamda methodlari final
  bo'lishi mumkin emas.
+ Abstract va concreate classlar entity bo'lishi mumkin. classlar entity bo'lmagan classlarni shuningdek entity
  classlarni extend olishi mumkin. 

