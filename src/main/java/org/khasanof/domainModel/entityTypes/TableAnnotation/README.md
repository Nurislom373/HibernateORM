# @Table Annotation

To explicitly give the name of the table or to specify other information about the table, we would use the
jakarta.persistence.Table annotation.

The schema attribute of the @Table annotation works only if the underlying database supports schemas (e.g. PostgreSQL).

Therefore, if you’re using MySQL or MariaDB, which do not support schemas natively (schemas being just an alias for
catalog), you need to use the catalog attribute, and not the schema one.

<hr/>

Table annotatsiyasi bizga tableni nomini aniq ko'rsatish yoki table haqidagi boshqa ma'lumotlarni ko'rsatish uchun
biz `jakarta.persistence.Table` annotatsiyasidan foydalanamiz.

@Table annotatsiyasining sxema atributi faqat asosiy database sxemalarni (masalan, PostgreSQL) qo'llab-quvvatlasagina
ishlaydi.

Shuning uchun, agar siz MySQL yoki MariaDB dan foydalanayotgan bo'lsangiz, ular asosan sxemalarni
qo'llab-quvvatlamaydi (sxemalar katalog uchun taxallus), siz sxemadan emas, balki katalog atributidan foydalanishingiz
kerak.