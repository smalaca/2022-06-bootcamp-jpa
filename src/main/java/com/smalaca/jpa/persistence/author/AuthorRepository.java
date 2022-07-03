package com.smalaca.jpa.persistence.author;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorRepository {
    private final EntityManager entityManager;

    public AuthorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void save(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    List<Author> findAll() {
        return entityManager.createQuery("SELECT i FROM Author i").getResultList();
    }
}
