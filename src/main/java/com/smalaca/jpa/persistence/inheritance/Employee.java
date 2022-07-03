package com.smalaca.jpa.persistence.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Person {
    private String company;
    private LocalDate workStartDate;
}
