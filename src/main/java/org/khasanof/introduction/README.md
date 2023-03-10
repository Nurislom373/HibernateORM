# Hibernate Introdudction
<strong>Hibernate</strong> 2001 yilda Gavin King tomonidan EJB2ga alternative sifatida boshlangan. 
O'sha paytdagi uning vazifasi murakkabliklarni soddalashtirish va yetishmayotgan xususiyatlarni
bartaraf etish orqali EJB2 tomonidan taklif qilingan ko'ra yaxshiroq barqarorlik imkoniyatlarini taqdim qilish edi.

### What is Hibernate?
Hibernate - bu Java uchun open-source ORM vositasi yani tool. Javadagi classlarni databasedagi tablelarga map qilish
uchun ishlatiladi. Hibernate classlarni tablelarga mapping qilish XML va Java Annotationlari yordamida amalga oshiriladi.
Hibernate nafaqat Java classlarni databasedagi tablelarga(va Java data typelarni SQL data typelariga) aylantirish bilan shug'illanadi.
Classlar o'rtasidagi one-to-one, one-to-many, many-to-many munosabatlarni tashkil qilish uchun imkoniyatlar mavjud.

- Hibernate barcha Relational Databaselarda CRUD operatsiyalarni bajarish uchun xususiyatlarni taqdim etadi.
- Hibernate JDBC bilan birga keladigan pla partish kodlarni yoq qiladi va resurslarni yo'q qilish bilan shug'ullanadi.
- Hibernate tranzaksiyalarni boshqarishni qo'llab quvvatlaydi.
- Biz XML yoki Annotatsiyalardan foydalanganligimiz sababli ilova va database o'rtasidagi abstraksiyani taminlaydi.
- Hibernate SQL o'xshagan kuchli query languageni (HQL) taqdim etadi.

### How does Hibernate Work?
biz qilishimiz kerak bo'lgan narsa, ba'zi metama'lumotlarni database bilan map qilishda ulardan qanday foydalanishni aytib beradigan annotatsiyalar ko'rsatish.
Ya'ni biz annotatsiyalarni qoyib ketamiz hibernate runtimeda annotatsiyalarni o'qiydi va ma'lumotlardan ba'zi SQL databaselariga querylarni yaratish uchun foydalanadi.
