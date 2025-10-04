package com.t7slution.databasecrudsqlquery.services;

import com.t7slution.databasecrudsqlquery.model.Todo;
import com.t7slution.databasecrudsqlquery.model.TodoCreateDTO;
import com.t7slution.databasecrudsqlquery.model.TodoResponseDTO;
import com.t7slution.databasecrudsqlquery.model.TodoUpdateDTO;

import java.util.List;

public interface TodoServices {

    List<TodoCreateDTO> findAllTodos();
    Todo findById(long id);
    TodoCreateDTO saveTodo(TodoCreateDTO todoCreateDTO);
    TodoCreateDTO updateTodo(long id, TodoCreateDTO todoCreateDTO);
    void deleteTodo(long id);

    TodoResponseDTO findFirstByTitle(String title);

        List<TodoResponseDTO> getTodoByTitle(String title);

}
