package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.query.criteria.JpaCriteriaUpdate;
import peaksoft.config.DatabaseConnection;
import peaksoft.models.User;

import java.util.List;

public class UserRepository implements AutoCloseable{
    EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();


    public void save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public User findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("select u from User u where u.id=?1", User.class).setParameter(1, id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from User u where u.id=?1").setParameter(1,id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
