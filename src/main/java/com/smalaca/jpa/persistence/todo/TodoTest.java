package com.smalaca.jpa.persistence.todo;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.util.UUID;

public class TodoTest {
    private static final RepositoriesFactory REPOSITORIES_FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
//        EntityManager entityManager;
        TodoRepository todoRepositoryOne = REPOSITORIES_FACTORY.toDoRepository();
        UUID todoIdOne = UUID.randomUUID();
        todoRepositoryOne.save(new Todo(todoIdOne, "conduct JPA training"));
        todoRepositoryOne.save(new Todo(UUID.randomUUID(), "conduct ORM training"));

//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(new Todo(UUID.randomUUID(), "conduct Hibernate training"));
//        transaction.commit();
        todoRepositoryOne.save(new Todo(UUID.randomUUID(), "conduct Hibernate training"));

        TodoRepository todoRepositoryTwo = REPOSITORIES_FACTORY.toDoRepository();

//        entityManager.find(Todo.class, todoIdOne)
        Todo byId = todoRepositoryTwo.findById(todoIdOne);
        System.out.println(byId);
    }
}
