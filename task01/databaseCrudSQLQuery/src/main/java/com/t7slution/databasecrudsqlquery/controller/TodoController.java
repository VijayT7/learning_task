package com.t7slution.databasecrudsqlquery.controller;

import com.t7slution.databasecrudsqlquery.model.Todo;
import com.t7slution.databasecrudsqlquery.model.TodoCreateDTO;
import com.t7slution.databasecrudsqlquery.model.TodoResponseDTO;
import com.t7slution.databasecrudsqlquery.services.TodoServices;
import com.t7slution.databasecrudsqlquery.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final UserService userService;

    private  final TodoServices todoServices;
    private final HandlerMapping resourceHandlerMapping;

    public TodoController(UserService userService, TodoServices todoServices, HandlerMapping resourceHandlerMapping) {
        this.userService = userService;
        this.todoServices = todoServices;
        this.resourceHandlerMapping = resourceHandlerMapping;
    }


    @GetMapping()
    public ResponseEntity<List<TodoCreateDTO>> getAllTodos(){
        return ResponseEntity.ok(todoServices.findAllTodos());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Todo> getTodoById(@PathVariable long id){
//        return ResponseEntity.ok(todoServices.findById(id));
//    }

        @GetMapping("/{id}")
        public ResponseEntity<Todo> getTodoById(@PathVariable long id){
            Todo t = todoServices.findById(id);
            return ResponseEntity.ok(t);
        }





//    @PostMapping
//    public TodoCreateDTO createTodo(@Valid @RequestBody TodoCreateDTO todoCreateDTO) {
//        ///////// for testing purpose only ///////////////
//        userService.registerUser("new user");
//        //////////////////////////////////////////////////
//        return todoServices.saveTodo(todoCreateDTO);
//    }


    // custom response status code
    @PostMapping
    public ResponseEntity<TodoCreateDTO> createTodo(@Valid @RequestBody TodoCreateDTO todoCreateDTO){
        TodoCreateDTO todo = todoServices.saveTodo(todoCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
//                .header("X-App-Version", "1.0") // this adds header in response
                .body(todo);
    }

    @PutMapping("/{id}")
    public TodoCreateDTO updateTodo(@Valid @PathVariable long id, @RequestBody TodoCreateDTO todoCreateDTO) {
        return todoServices.updateTodo(id, todoCreateDTO);
    }

//    @DeleteMapping("/{id}")
//    public String deleteTodo(@PathVariable long id) {
//        todoServices.deleteTodo(id);
//        return "Deleted";
//    }


    // delete API with 204 response code (no content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
        todoServices.deleteTodo(id);
        return ResponseEntity.noContent().build();
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

