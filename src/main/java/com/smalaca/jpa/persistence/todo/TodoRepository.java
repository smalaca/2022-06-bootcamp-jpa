package com.smalaca.jpa.persistence.todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.UUID;

public class TodoRepository {
    private final EntityManager entityManager;

    public TodoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    UUID save(Todo todo) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(todo);
        transaction.commit();
        return todo.getId();
    }

    Todo findById(UUID id) {
        return entityManager.find(Todo.class, id);
    }

    void deleteById(UUID id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Todo todoToRemove = findById(id);
        entityManager.remove(todoToRemove);
        transaction.commit();
    }

    List<Todo> findAll() {
        return entityManager.createQuery(
                "SELECT t FROM Todo t WHERE t.subject !='' ORDER BY subject ASC").getResultList();
    }

    void update(Todo todo) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(todo);
        transaction.commit();
    }

    void close() {
        entityManager.close();
    }
}
