package com.smalaca.jpa.persistence.todo;

import lombok.ToString;

@ToString
public class TodoCategory {
    private final String code;
    private final String description;

    public TodoCategory(String code, String description) {
        this.code = code;
        this.description = description;
    }

    String getCode() {
        return code;
    }

    String getDescription() {
        return description;
    }
}
