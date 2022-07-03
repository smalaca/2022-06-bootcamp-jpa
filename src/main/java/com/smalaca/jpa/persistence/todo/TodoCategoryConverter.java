package com.smalaca.jpa.persistence.todo;

import javax.persistence.AttributeConverter;

public class TodoCategoryConverter implements AttributeConverter<TodoCategory, String> {
    @Override
    public String convertToDatabaseColumn(TodoCategory todoCategory) {
        if (todoCategory == null) {
            return "";
        } else {
            return todoCategory.getCode() + ";" + todoCategory.getDescription();
        }
    }

    @Override
    public TodoCategory convertToEntityAttribute(String value) {
        if (value.contains(";")) {
            String[] parts = value.split(";");
            return new TodoCategory(parts[0], parts[1]);
        } else {
            return null;
        }
    }
}
