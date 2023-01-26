# Component / Embedded

Most often, embeddable types are used to group multiple basic type mappings and reuse them across several entities.

the @Embeddable annotation to declare that a class will be embedded by other entities. @Embedded is used to embed a 
type into another entity.

<hr/>

embeddable xususiyatlarni o'z ichiga olgan bitta ob'ektni bitta
ma'lumotlar bazasi jadvaliga map qilish uchun ishlatamiz.

Ko'pincha embeddable classlar bir nechta asosiy typelar guruhini bir nechta entitylarga 
map qilib qayta ishlatilsh uchun ishlatiladi.

@Embeddable annotatsiyasi boshqa classlar tomonidan o'rnatilishi(embedded) ni e'lon qilish uchun.

@Embedded annotatsiyasi embedded qilingan classni boshqa classga joylashtirish uchun ishlatiladi.