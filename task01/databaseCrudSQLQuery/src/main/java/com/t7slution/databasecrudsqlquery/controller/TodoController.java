package com.t7slution.databasecrudsqlquery.controller;

import com.t7slution.databasecrudsqlquery.model.Todo;
import com.t7slution.databasecrudsqlquery.model.TodoDTO;
import com.t7slution.databasecrudsqlquery.services.TodoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private  final TodoServices todoServices;

    public TodoController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TodoDTO>> getAllTodos(){
        return ResponseEntity.ok(todoServices.findAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable long id){
        System.out.println("getTodoById_________________________________" + id);
        return ResponseEntity.ok(todoServices.findById(id));
    }

    @PostMapping
    public TodoDTO createTodo(@RequestBody TodoDTO todoDTO) {
        return todoServices.saveTodo(todoDTO);
    }

    @PutMapping("/{id}")
    public TodoDTO updateTodo(@PathVariable long id, @RequestBody TodoDTO todoDTO) {
        return todoServices.updateTodo(id, todoDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable long id) {
        todoServices.deleteTodo(id);
        return "Deleted";
    }

//    @GetMapping("/{title}")
//    public TodoDTO getTodoByTitle(@PathVariable String title) {
//        return todoServices.findFirstByTitle(title);
//    }

//    @GetMapping("/{title}")
//    public List<TodoDTO> getAllTodos(@PathVariable String title) {
//        return todoServices.getTodoByTitle(title);
//    }



}

