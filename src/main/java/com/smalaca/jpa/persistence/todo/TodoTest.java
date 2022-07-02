package com.smalaca.jpa.persistence.todo;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.util.UUID;

public class TodoTest {
    private static final RepositoriesFactory REPOSITORIES_FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        UUID todoIdOne = requestOne();
        requestTwo(todoIdOne);

        REPOSITORIES_FACTORY.close();
    }

    private static void requestTwo(UUID todoIdOne) {
        TodoRepository todoRepositoryTwo = REPOSITORIES_FACTORY.toDoRepository();
        Todo byId = todoRepositoryTwo.findById(todoIdOne);
        todoRepositoryTwo.close();
        System.out.println(byId);
    }

    private static UUID requestOne() {
        TodoRepository todoRepositoryOne = REPOSITORIES_FACTORY.toDoRepository();
        UUID todoIdOne = UUID.randomUUID();
        todoRepositoryOne.save(new Todo(todoIdOne, "conduct JPA training"));
        todoRepositoryOne.save(new Todo(UUID.randomUUID(), "conduct ORM training"));
        todoRepositoryOne.save(new Todo(UUID.randomUUID(), "conduct Hibernate training"));

        todoRepositoryOne.close();
        return todoIdOne;
    }
}
