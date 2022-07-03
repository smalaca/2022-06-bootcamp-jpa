package com.smalaca.jpa.persistence.inheritance;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public abstract class Person {
    @Id
    @GeneratedValue
    private UUID id;

    private String login;
    private String name;
    private String surname;
}
