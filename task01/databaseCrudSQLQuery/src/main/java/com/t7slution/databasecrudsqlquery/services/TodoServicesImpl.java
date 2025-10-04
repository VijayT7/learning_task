package com.t7slution.databasecrudsqlquery.services;


import com.t7slution.databasecrudsqlquery.exception.TodoNotoFoundException;
import com.t7slution.databasecrudsqlquery.model.Todo;
import com.t7slution.databasecrudsqlquery.model.TodoCreateDTO;
import com.t7slution.databasecrudsqlquery.model.TodoResponseDTO;
import com.t7slution.databasecrudsqlquery.model.TodoUpdateDTO;
import com.t7slution.databasecrudsqlquery.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServicesImpl implements TodoServices {

    private final TodoRepository todoRepository;

    public TodoServicesImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoCreateDTO> findAllTodos() {
        return todoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

//    @Override
//    public Todo findById(long id) {
//        Todo todo = todoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("not found"));
//        return todo;
//    }

    @Override
    public Todo findById(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotoFoundException(id));
        return todo;
    }


    @Override
    public TodoResponseDTO saveTodo(TodoCreateDTO todoCreateDTO) {
        Todo todo = convertToEntity(todoCreateDTO);
        Todo savedTodo = todoRepository.save(todo);
        TodoResponseDTO t = convertToDTO(savedTodo);
        return t;
//        return  convertToDTO(savedTodo);
    }

    @Override
    public TodoResponseDTO updateTodo(long id, TodoCreateDTO todoCreateDTO) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setTitle(todoCreateDTO.getTitle());
        todo.setDescription(todoCreateDTO.getDescription());
        Todo updatedTodo = todoRepository.save(todo);
        return convertToDTO(updatedTodo);
    }

    @Override
    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }


    /////////////////////// ---   query  ---  //////////////////////////////

    @Override
    public TodoResponseDTO findFirstByTitle(String title) {
        Todo todo = todoRepository.findFirstByTitle(title);
        return convertToDTO(todo);
    }

    @Override
    public List<TodoResponseDTO> getTodoByTitle(String title) {
        List<Todo> todos = todoRepository.getTodoByTitle(title);
        List<TodoResponseDTO> todoResponseDTOS = todos.stream().map((todo) -> convertToDTO(todo)).collect(Collectors.toList());
        return todoResponseDTOS;
    }





    /////////////////////// ---   -----  ---  //////////////////////////////



    private TodoResponseDTO convertToDTO(Todo todo){
        TodoResponseDTO s =new TodoResponseDTO(todo.getId(), todo.getTitle(), todo.getDescription());
        return s;
    }

    private Todo convertToEntity(TodoCreateDTO todoCreateDTO){
        Todo todo = new Todo();
        todo.setTitle(todoCreateDTO.getTitle());
        todo.setDescription(todoCreateDTO.getDescription());
        return todo;
    }


}
