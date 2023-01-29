# @Subselect annotation

You can map an entity to a SQL query using the @Subselect annotation.

You can’t use this entity to perform any write operations. Hibernate would try to execute the operation on the SQL
statement provided by the @Subselect annotation. You should, therefore, annotate the entity with @Immutable, use the
field-based access strategy and omit all setter methods.

Hibernate doesn’t know which database tables are used by the SQL statement configured in the @Subselect annotation. You
can provide this information by annotating the entity with @Synchronize. That enables Hibernate to flush pending state
transitions on the ETAccount, ETAccountTransaction and ETClient entities before selecting a ETSQLQueryEntity entity.

<hr/>

@Subselect annotatsiyasidan foydalangan holda query qaytgan resultni entityga solishtirishimiz(map) qilishimiz mumkin.

hech qanday yozish operatsiyalarni uchun ushbu entitydan foydalana olmaymiz. Hibernate @Subselect annotatsiyasni tomonidan
taqdim etilgan SQL queryni bajaradi. 

Hibernate @Subselect annotatsiyasidagi SQL queryni qaysi tablelar bilan ishlatishni bilmaydi. Qaysi tablelar bilan ishlash
kerakligini @Sychronize annotatsiyasi bilan orqali taqdim etishimiz mumkin.