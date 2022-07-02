package com.smalaca.jpa.persistence.todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class TodoRepository {
    private final EntityManager entityManager;

    public TodoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void save(Todo todo) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(todo);
        transaction.commit();
    }

    Todo findById(UUID id) {
        return entityManager.find(Todo.class, id);
    }
}
