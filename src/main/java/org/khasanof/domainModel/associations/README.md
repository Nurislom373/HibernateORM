# Associations

Association mappings are one of the key features of JPA and Hibernate. They model the relationship between two database
tables as attributes in your domain model. That allows you to easily navigate the associations in your domain model and
JPQL or Criteria queries.

When mapping a JPA entity, besides the underlying table columns, the application developer can map entity relationships
either in one direction or in a bidirectional way. This is another impedance mismatch between the object-oriented Domain
Model and relational database system because, when using an ORM tool, the parent and the child-side can reference each
other.

Associations describe how two or more entities form a relationship based on a database joining semantics.

Supports 4 different types of associations.

+ one-to-one
+ many-to-one
+ one-to-many
+ many-to-many

You can map each of them as a uni- or bidirectional association. That means you can either model them as an attribute on
only one of the associated entities or on both. That has no impact on your database mapping, but it defines in which
direction you can use the relationship in your domain model and JPQL or Criteria queries. I will explain that in more
detail in the first example.

<hr/>

Assosatsiya JPA va Hibernate ni asosiy xususiyatlaridan biri. Ular Domen Modelimizni atrubutlar sifatida 2ta tablelar
o'rtasidagi munosabatlarni modellashtiradi. Assosatsiyalar ikki yoki undan ko'p bo'lgan entitylari o'rtasidagi
munosabatlarni tasvirlsh uchun.

4 xil turdagi assosatsiyalarni qo'llab quvvatlaydi.

+ one-to-one
+ many-to-one
+ one-to-many
+ many-to-many

Ularni har birini bir yoki ikki tomonlama assosatsiya sifatida map qilishimiz mumkin. Bu shuni anglatadiki, biz ularni
bog'langan entitylarning faqat bittasida yoki ikktasida atribut sifatida modellashimiz mumkin. Bu bizga databasega 
map qilishga ta'sir qilmaydi, lekin domen modelimizning va JPQL va Criteria querielaridagi munosabatlardan qaysi
yo'nalishda foydalanishimiz mumkinligini belgilaydi. 
