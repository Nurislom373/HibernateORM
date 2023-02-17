# @SortNatural

Hibernate also has the ability to map sorted and ordered sets. A sorted set orders its elements in memory via an
associated Comparator; an ordered set is ordered via SQL when the set is loaded.

An ordered set does not perform any sorting in-memory. If an element is added after the collection is loaded, the
collection would need to be refreshed to re-order the elements. For this reason, ordered sets are not recommended - if
the application needs ordering of the set elements, a sorted set should be preferred. For this reason, it is not covered
in the User Guide. See the javadocs for jakarta.persistence.OrderBy or org.hibernate.annotations.OrderBy for details.

```java

@Embeddable
public class Name implements Comparable<Name> {
    private String first;
    private String last;

    // ...
}

@Entity
public class EntityWithNaturallySortedSet {
    // ...
    @ElementCollection
    @SortNatural
    private SortedSet<Name> names;
}
```

```java
public class NameComparator implements Comparator<Name> {
	static final Comparator<Name> comparator = Comparator.comparing( Name::getLast ).thenComparing( Name::getFirst );

	@Override
	public int compare(Name o1, Name o2) {
		return comparator.compare( o1, o2 );
	}
}

@Entity
public class EntityWithSortedSet {
	// ...
	@ElementCollection
	@SortComparator( NameComparator.class )
	private SortedSet<Name> names;
}
```


