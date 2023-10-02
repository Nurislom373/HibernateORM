package org.khasanof.news.check_annotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.NaturalId;
import org.khasanof.news.AbstractSessionFactory;

/**
 * @author Nurislom
 * @see org.khasanof.news.check_annotation
 * @since 10/1/2023 6:56 PM
 */
public class CheckAnnotationTest extends AbstractSessionFactory {

    public static void main(String[] args) {
        SessionFactory sessionFactory = SESSION_FACTORY_BUILDER.sessionFactoryBuild(Book.class);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book book = new Book();
        book.setId(1L);
        book.setPrice(49.99d);
        book.setTitle("High-Performance Java Persistence");
        book.setIsbn("11-11-2016");

        session.persist(book);
        transaction.commit();
    }

}

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "CASE WHEN isbn IS NOT NULL THEN LENGTH(isbn) = 10 ELSE true END")
class Book {

    @Id
    private Long id;

    private String title;

    @NaturalId
    private String isbn;

    private Double price;

}
