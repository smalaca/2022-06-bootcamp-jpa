package com.smalaca.jpa.persistence.basket;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class BasketIdentifier {
    private final String login;
    private final int visits;
    private final LocalDate creationDate;

    BasketIdentifier(String login, int visits, LocalDate creationDate) {
        this.login = login;
        this.visits = visits;
        this.creationDate = creationDate;
    }

    static BasketIdentifier now(String login, int visits) {
        return new BasketIdentifier(login, visits, LocalDate.now());
    }
}
