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

        entityManager.getTransaction().begin();;

        entityManager.merge(newVendor);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<Vendor> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Vendor> vendors = entityManager.createQuery("select b from Vendor b", Vendor.class)
                .getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();

        return vendors;
    }

    public Vendor findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Vendor vendor = entityManager.createQuery("select v from Vendor v where v.id =?1", Vendor.class)
                .setParameter(1, id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return vendor;
    }

//    public void deleteById(Long id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        Vendor vendor = entityManager.createQuery("delete from Book b where b.id =?1").setParameter(1, id).getSingleResult();
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }


    @Override
    public void close() throws Exception {

    }
}
