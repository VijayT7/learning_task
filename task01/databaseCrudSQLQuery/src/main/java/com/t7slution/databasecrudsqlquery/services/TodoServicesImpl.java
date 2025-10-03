package com.t7slution.databasecrudsqlquery.services;


import com.t7slution.databasecrudsqlquery.model.Todo;
import com.t7slution.databasecrudsqlquery.model.TodoDTO;
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
    public List<TodoDTO> findAllTodos() {
        return todoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Todo findById(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        return todo;
    }

    @Override
    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = convertToEntity(todoDTO);
        Todo savedTodo = todoRepository.save(todo);
        TodoDTO t = convertToDTO(savedTodo);
        return t;
//        return  convertToDTO(savedTodo);
    }

    @Override
    public TodoDTO updateTodo(long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setTitle(todoDTO.title());
        todo.setDescription(todoDTO.description());
        Todo updatedTodo = todoRepository.save(todo);
        return convertToDTO(updatedTodo);
    }

    @Override
    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }


    /////////////////////// ---   query  ---  //////////////////////////////

    @Override
    public TodoDTO findFirstByTitle(String title) {
        Todo todo = todoRepository.findFirstByTitle(title);
        return convertToDTO(todo);
    }

    @Override
    public List<TodoDTO> getTodoByTitle(String title) {
        List<Todo> todos = todoRepository.getTodoByTitle(title);
        List<TodoDTO> todoDTOs = todos.stream().map((todo) -> convertToDTO(todo)).collect(Collectors.toList());
        return todoDTOs;
    }





    /////////////////////// ---   -----  ---  //////////////////////////////



    private TodoDTO convertToDTO(Todo todo){
        TodoDTO s =new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription());
        return s;
    }

    private Todo convertToEntity(TodoDTO todoDTO){
        Todo todo = new Todo();
        todo.setTitle(todoDTO.title());
        todo.setDescription(todoDTO.description());
        return todo;
    }


}
