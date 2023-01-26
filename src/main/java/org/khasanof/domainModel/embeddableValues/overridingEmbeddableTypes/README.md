# Overrding Embeddedable Types

Although from an object-oriented perspective, it’s much more convenient to work with embeddable types, when we reuse the same embeddable multiple times on the same class, the Jakarta Persistence specification requires to set the associated column names explicitly.

This requirement is due to how object properties are mapped to database columns. By default, Jakarta Persistence expects a database column having the same name with its associated object property. When including multiple embeddables, the implicit name-based mapping rule doesn’t work anymore because multiple object properties could end-up being mapped to the same database column.

When an embeddable type is used multiple times, Jakarta Persistence defines the @AttributeOverride and @AssociationOverride annotations to handle this scenario to override the default column names defined by the Embeddable.

<hr/>

Ob'ektga yo'naltirilgan dasturlash nuqtai nazardan, embeddable typelar bilan ishlash ancha qulayroq bo'lsa-da, biz bir xil embeddabledan bir xil sinfda bir necha marta foydalansak, Jakarta Persistence spetsifikatsiyasi bog'langan column nomlarini aniq belgilashni talab qiladi.

Publisher classidagi name field bor biz ushbu fieldni ebook_pub_name ga aylantirib database saqlanishini hohlaymiz.
Buni amalga oshirish uchun embeddable classini propertieslarni qilishimiz kerak.

Biz embeddable typedagi propertylarni override qilishimiz uchun @AttributeOverrides va @AttributeOverride dan foydalanamiz.