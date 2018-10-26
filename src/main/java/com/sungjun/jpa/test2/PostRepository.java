package com.sungjun.jpa.test2;

/*
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Post add(Post post) {
        entityManager.persist(post);
        return post;
    }

    public void delete(Post post) {
        entityManager.remove(post);
    }

    public List<Post> findAll() {
        return entityManager.createQuery("SELECT p FROM Post AS p", Post.class)
                .getResultList();
    }
}
*/

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{}
