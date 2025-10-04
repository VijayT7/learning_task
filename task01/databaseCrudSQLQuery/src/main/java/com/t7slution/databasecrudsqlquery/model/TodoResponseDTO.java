package com.t7slution.databasecrudsqlquery.model;

public class TodoResponseDTO extends TodoUpdateDTO {
    public TodoResponseDTO(Long id, String title, String description) {
        super(id, title, description);
    }
}
