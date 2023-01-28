# Custom Instantiation

Embeddables are simple Java objects. They provide an easy way to define and group a set of attributes that become
part of your entity. Developers often use them to create reusable mapping information and handle them using the same
piece of business code.

Unfortunately, the JPA specification and Hibernate until version 6.0.0, required your embeddable to have a default
constructor. This might be OK if you’re fetching an entity from the database. Hibernate then automatically sets all
attributes before providing the object to your business code. But a default constructor is not always a great idea.
E.g., if some of the attributes are mandatory and you instantiate embeddables in your business code or frontend. In that
case, a constructor that sets all mandatory attributes would be a much better fit.

You can use it as an attribute type on one of your entity classes and annotate the attribute with @Embedded.

Since Hibernate 6.0.0, you can easily define how Hibernate instantiates and initializes your embeddable. You can use
that, for example, to remove the requirement of a default constructor. I will show you how to do that in this article.

By default, Hibernate would call the default constructor of the Address embeddable. After that, it uses reflection to
set all its attributes when you fetch an Author entity from the database. Since Hibernate 6, you can customize the
instantiation of the embeddable by providing an EmbeddableInstantiator.

Let’s use this to avoid the default constructor of the Address embeddable and use a constructor that sets all attributes
instead.

In the next step, you have to implement the EmbeddableInstantiator interface. This isn’t complicated. The interface only
defines 3 methods. One method checks if an object is an instance of the handled embeddable class. Another one checks if
an object is of the same class as the embeddable. And the last method instantiates the embeddable object.

the EmbeddableInstantiator contract introduced in Hibernate 6 gives you more flexibility when working with embeddables.
It gives you full control over the instantiation and initialization of your embeddable objects. You can use this for
various things. You could perform additional business logic or transform or calculate attributes values before
instantiating the embeddable. Or you can avoid the default constructor and call a constructor that fully initializes
your embeddable object instead.

<hr/>

Embeddablelar oddiy Java objectlaridir. Ular sizning objectingizga aylanadigan atributlar to'plamini aniqlash va
guruhlashning oson yo'lini taqdim etadi. Developerlar ko'pincha ulardan qayta foydalanish mumkin bo'lgan mapping
ma'lumotlarni yaratish uchun foydanaladilar.

Siz uni classlaringizdan birida atribut turi sifatida ishlatishingiz va atributga @Embedded bilan izoh berishingiz
mumkin.

Default Hibernate Name embeddablening standart konstructoridan foydalanadi. Shundan so'ng databasedan Name objectni
olganimizda uning barcha atrubutlari o'rnatish uchun reflectiondan foydalanadi. Hibernate 6dan boshlab
EmbeddableInstantiator-ni taqdim etdi. Ushbu `EmbeddableInstantiator` interface orqali siz embeddablening namunasini
sozlashingiz mumkin.

Bu bizga default constructordan qochish va uning o'rniga barcha atributlarni o'rnatadigan konstructordan foydalanish
uchun ushbu interfacedan foydalanamiz.

Biz embeddable instaniation ishlatishimiz uchun EmbeddableInstaniation interfaceni amalga oshirishimiz kerak.
Ushbu interface 3ta method belgilaydi.

1. instantiate - embeddable objectni yaratadi
2. isInstance - object classning instance ekanligi tekshiradi.
3. isSameClass - objectning embeddable objecti bilan bir xil classga tegishli ekanligi tekshiriladi.