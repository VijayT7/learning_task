package com.t7slution.databasecrudsqlquery.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TodoUpdateDTO extends TodoCreateDTO {

    @NotNull(message = "Id is required")
    @Positive(message = "Id must be positive number")
    private long id;

    public TodoUpdateDTO(Long id, String title, String description) {
        super(title, description);
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
