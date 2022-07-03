package com.smalaca.jpa.persistence.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USER")
public class User extends Person {
    private long currentSessionLength;
    private long lastSessionLength;
}
