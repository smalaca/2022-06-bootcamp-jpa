package com.smalaca.jpa.persistence;

import com.smalaca.jpa.persistence.todo.TodoRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepositoriesFactory {
    private final EntityManagerFactory entityManagerFactory;

    private RepositoriesFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public static RepositoriesFactory create() {
        return new RepositoriesFactory(Persistence.createEntityManagerFactory("ToDo"));
    }

    public TodoRepository toDoRepository() {
        return new TodoRepository(entityManagerFactory.createEntityManager());
    }
}
