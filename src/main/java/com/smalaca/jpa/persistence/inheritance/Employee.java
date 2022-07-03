package com.smalaca.jpa.persistence.inheritance;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Employee extends Person {
    private String company;
    private LocalDate workStartDate;
}
