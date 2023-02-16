# Collections

Hibernate supports mapping collections (java.util.Collection and java.util.Map subtypes) in a variety of ways.
Collections cannot be nested, meaning Hibernate does not support mapping `List<List<?>>`, for example.

<hr/>

Hibernate turli usullarda collectionlarni(`java.util.Collection` and `java.util.Map`) map qilish qo'llab quvvatlaydi.
Hibernate nested collectionlarni ya'ni `List<List<?>>`, ichma ich collectionlarni qo'llab quvvatlamaydi.

## Basic List Mapping

```java

@Entity
public class EntityWithList {
    // ...
    @ElementCollection
    private List<Name> names;
}
```

## @ElementCollection

Element collections may contain values of either basic or embeddable types.
An @ElementCollection enables you to map a Collection of values that are not an entity itself. This might seem like an
easy solution for lists of basic attributes, like the phone numbers of a person. In the database, Hibernate maps the
@ElementCollection to a separate table. Each value of the collection gets stored as a separate record.

But the mapping as an @ElementCollection has a downside: The elements of the collection don’t have their own identity
and lifecycle. They are a part of the surrounding entity. This often becomes a performance issue if you need to change
the elements in the collection. Because they don’t have their own identity, all elements of an @ElementCollection are
always read, removed, and written, even if you only add, change, or remove one of them. This makes write operations on
an @ElementCollection much more expensive than the same operation on a mapped association.

I, therefore, recommend modeling an additional entity and a one-to-many association instead of an @ElementCollection.
This enables you to use lazy loading and to update these values independently of each other. Doing that requires only a
minimum amount of code but provides much better performance.

<hr/>

Element collectionlar basic yani asosiy typelarni yoki embeddable type saqlashi mumkin.  
@ElementCollection entity bo'lmagan qiymatlarni saqlash imkoni beradi. Bu odamning telefon raqamlari kabi asosiy
atributlar ro'yxati uchun oson yechim kabi ko'rinishi mumkin. Databaseda Hibernate @ElementCollection ni alohida
tablega moslashtiradi. Collectionning har bir qiymat alohida yozuv sifatida saqlanadi.

Ammo @ElementCollection sifatida saqlashning o'ziga yarasha salbiy tomonlari ham bor:
Collection elementlarning identity va lifecycle yo'q. Collectiondagi elementlarni o'zgartirish kerak bo'lsa, bu
ko'pincha ishlash muammosiga aylanadi. Ularning shaxsiy identifikatori yo'qligi sababli, @ElementCollection ning barcha
elementlari har doim o'qiladi, o'chiriladi va yoziladi, hatto ulardan birini qo'shsangiz, o'zgartirsangiz yoki olib
tashlasangiz ham. Bu @ElementCollection-da yozish operatsiyalarini assotsiatsiyadagi bir xil operatsiyasilardan ancha
sekinroq bo'ladi.

Shuning uchun @ElementCollection o'rniga one-to-many assotsiatsiyani tavsiya qilinadi. Bu bizga lazy load qilishdan
foydalanish va ushbu qiymatlarni bir-biridan mustaqil ravishda yangilash imkonini beradi. Buning uchun faqat minimal kod
miqdori talab qilinadi, lekin ancha yaxshi ishlashni ta'minlaydi. 