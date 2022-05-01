package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DatabaseConnection;
import peaksoft.models.Book;
import peaksoft.models.Vendor;

import java.util.List;

public class VendorRepository implements AutoCloseable{

    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    public void save(Vendor newVendor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newVendor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void merge(Vendor newVendor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(newVendor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Vendor findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Vendor vendor = entityManager.createQuery("select v from Vendor v where v.id =?1", Vendor.class).setParameter(1, id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return vendor;
    }

    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Vendor.class,id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Vendor> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Vendor> vendors = entityManager.createQuery("select v from Vendor v", Vendor.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return vendors;
    }

    @Override
    public void close() throws Exception {

    }
}
