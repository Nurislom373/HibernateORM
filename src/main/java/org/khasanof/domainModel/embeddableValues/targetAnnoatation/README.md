# @Target Annotation

The @Target annotation is used to specify the implementation class of a given association that is mapped via an interface. The @ManyToOne, @OneToOne, @OneToMany, and @ManyToMany feature a targetEntity attribute to specify the actual class of the entity association when an interface is used for the mapping.

The @ElementCollection association has a targetClass attribute for the same purpose.

However, for simple embeddable types, there is no such construct and so you need to use the Hibernate-specific @Target annotation instead.

<hr/>

@Target annotatsiyasi interface orqali mapped qilingan associationning amal(impl)ga oshirish classni belgilash uchun ishlatiladi.
Mapped - boshqa qilib aytganda bir biri bilan bog'langan. 

@MantToOne, @OneToOne, @OneToMany, @ManyToMany annotatsiyalarni map qilish uchun interfacedan foydalanilganda object 
assotsiatsiyaning haqiqiy classini belgilash uchun targetEntity atributiga ega.

Biroq, Oddiy embeddable typelar uchun bunday konstruksiya yo'q va shuning uchun uning o'rniga Hibernate xos @Target 
annotatsiyasidan foydalanishingiz kerak.

