package com.smalaca.jpa.persistence.inheritance;

import javax.persistence.Entity;

@Entity
public class User extends Person {
    private long currentSessionLength;
    private long lastSessionLength;
}
