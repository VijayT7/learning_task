package com.t7slution.databasecrudsqlquery.services;

import com.t7slution.databasecrudsqlquery.model.Todo;
import com.t7slution.databasecrudsqlquery.model.TodoDTO;

import java.util.List;

public interface TodoServices {

    List<TodoDTO> findAllTodos();
    Todo findById(long id);
    TodoDTO saveTodo(TodoDTO todoDTO);
    TodoDTO updateTodo(long id, TodoDTO todoDTO);
    void deleteTodo(long id);

    TodoDTO findFirstByTitle(String title);

        List<TodoDTO> getTodoByTitle(String title);

}
