package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import peaksoft.config.DatabaseConnection;
import peaksoft.models.Book;
import peaksoft.models.Vendor;

import java.util.List;

public class BookRepository implements AutoCloseable{

    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    public void save(Book newBook) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();;

        entityManager.persist(newBook);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Book b where b.id =?1").setParameter(1,id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Book> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return books;
    }

    public Book findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.createQuery("select b from Book b where b.id=?1", Book.class).setParameter(1, id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
