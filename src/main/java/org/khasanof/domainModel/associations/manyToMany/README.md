# ManyToMany Association

Many-to-Many Associations
Many-to-Many relationships are another often used association type. On the database level, it requires an additional
association table which contains the primary key pairs of the associated entities. But as you will see, you don’t need
to map this table to an entity.

A typical example for such a many-to-many association are Products and Stores. Each Store sells multiple Products and
each Product gets sold in multiple Stores.

Similar to the many-to-one association, you can model a many-to-many relationship as a uni- or bidirectional
relationship between two entities.

<hr/>

