package com.smalaca.jpa.persistence.author;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.todo.Todo;
import com.smalaca.jpa.persistence.todo.TodoRepository;

import java.util.List;

public class AuthorTest {
    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        addAll();

        System.out.println("-------------------");
        findAllAuthors();

        System.out.println("-------------------");
        findAllTodos();

        FACTORY.close();
    }

    private static void findAllAuthors() {
        AuthorRepository repository = FACTORY.authorRepository();
        List<Author> items = repository.findAll();
        items.forEach(System.out::println);
    }

    private static void findAllTodos() {
        TodoRepository repository = FACTORY.toDoRepository();
        List<Todo> items = repository.findAll();
        items.forEach(System.out::println);
    }

    private static void addAll() {
        AuthorRepository authorRepository = FACTORY.authorRepository();
        Author peterParker = new Author("peter parker");
        authorRepository.save(peterParker);
        authorRepository.save(new Author("tony stark"));
        Author gamora = new Author("gamora");
        authorRepository.save(gamora);
        Author drax = new Author("drax");
        authorRepository.save(drax);

        TodoRepository todoRepository = FACTORY.toDoRepository();
        Todo todoOne = new Todo("conduct Hibernate training");
        todoOne.add(gamora);
        todoRepository.save(todoOne);

        Todo todoTwo = new Todo("conduct Refactoring training");
        todoTwo.add(drax);
        todoRepository.save(todoTwo);

        Todo todoThree = new Todo("conduct Testing training");
        todoThree.add(peterParker);
        todoRepository.save(todoThree);
    }
}
