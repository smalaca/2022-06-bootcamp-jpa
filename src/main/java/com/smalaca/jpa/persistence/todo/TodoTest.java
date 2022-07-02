package com.smalaca.jpa.persistence.todo;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.util.List;
import java.util.UUID;

public class TodoTest {
    private static final RepositoriesFactory REPOSITORIES_FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        UUID todoIdOne = createTodos();
        System.out.println("---------------------");

        findOneTodo(todoIdOne);
        System.out.println("---------------------");

        modifyOneTodo(todoIdOne);
        System.out.println("---------------------");

        findAllTodos();
        System.out.println("---------------------");

        deleteOneTodo(todoIdOne);
        System.out.println("---------------------");

        findAllTodos();
        System.out.println("---------------------");

        REPOSITORIES_FACTORY.close();
    }

    private static void modifyOneTodo(UUID id) {
        TodoRepository repository = REPOSITORIES_FACTORY.toDoRepository();
        Todo todo = repository.findById(id);
        todo.changeSubjectTo("Prepare exercises for JPA training");
        repository.update(todo);
    }

    private static void deleteOneTodo(UUID id) {
        TodoRepository repository = REPOSITORIES_FACTORY.toDoRepository();
        repository.deleteById(id);
    }

    private static void findAllTodos() {
        TodoRepository repository = REPOSITORIES_FACTORY.toDoRepository();
        List<Todo> todos = repository.findAll();
        todos.forEach(System.out::println);
    }

    private static void findOneTodo(UUID todoIdOne) {
        TodoRepository repository = REPOSITORIES_FACTORY.toDoRepository();
        Todo byId = repository.findById(todoIdOne);
        System.out.println(byId);
    }

    private static UUID createTodos() {
        TodoRepository repository = REPOSITORIES_FACTORY.toDoRepository();
        UUID todoIdOne = UUID.randomUUID();
        repository.save(new Todo(todoIdOne, "conduct JPA training"));
        repository.save(new Todo(UUID.randomUUID(), "conduct ORM training"));
        repository.save(new Todo(UUID.randomUUID(), "conduct Hibernate training"));
        repository.save(new Todo(UUID.randomUUID(), "conduct Refactoring training"));
        repository.save(new Todo(UUID.randomUUID(), "conduct Testing training"));
        return todoIdOne;
    }

}
