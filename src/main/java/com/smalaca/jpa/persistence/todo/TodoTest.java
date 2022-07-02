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
        repository.save(new Todo("conduct ORM training"));
        Todo defined = new Todo("conduct Hibernate training");
        defined.defined();
        repository.save(defined);
        repository.save(new Todo("conduct Refactoring training"));
        Todo inProgress = new Todo("conduct Testing training");
        inProgress.inProgress();
        repository.save(inProgress);
        Todo todo = new Todo("conduct JPA training");
        return repository.save(todo);
    }

}
