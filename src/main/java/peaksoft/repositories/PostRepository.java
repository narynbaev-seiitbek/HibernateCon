package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DatabaseConnection;
import peaksoft.models.Post;

import java.util.List;

public class PostRepository implements AutoCloseable{

    EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();


    public void save(Post post) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Post post) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Post findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("select p from Post p where p.id=?1", Post.class).setParameter(1, id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return post;
    }

    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Post p where p.id=?1").setParameter(1,id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Post> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Post> posts = entityManager.createQuery("select p from Post p", Post.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return posts;
    }


    @Override
    public void close() throws Exception {

    }
}
