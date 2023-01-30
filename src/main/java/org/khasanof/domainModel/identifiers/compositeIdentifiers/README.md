# Composite Identifiers

Besides the simple identifiers we've seen so far, Hibernate also allows us to define composite identifiers.

A composite id is represented by a primary key class with one or more persistent attributes.

The primary key class must fulfil several conditions:
+ It should be defined using @EmbeddedId or @IdClass annotations.
+ It should be public, serializable and have a public no-arg constructor.
+ Finally, it should implement equals() and hashCode() methods.

<hr/>

Hibernate bundan oldingi simpleIdentifier packageda ko'rgan oddiy identifikatorlardan tashqari, Hibernate bizga
Composite identifikatorlarni foydalanish imkoni beradi.

Composite identifikator bir yoki bir nechta doimiy atributga ega primary key class bilan ifodalanadi.

primary key class bir nechta shartlarga javob berishi kerak:

+ U `@EmbeddedId` yoki `@IdClass` annotatsiya qoyilgan bo'lishi kerak.
+ Ushbu class public va `Serializable` interfaceni amalga oshirgan bo'lishi kerak. Hamda public no-arg constructori 
bo'lishi kerak.
+ `equals()` va `hashCode()` methodlarni impl qilgan bolishi ham kerak.
