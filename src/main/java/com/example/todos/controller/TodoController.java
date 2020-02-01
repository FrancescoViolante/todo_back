package com.example.todos.controller;


import com.example.todos.dto.TodoDto;
import com.example.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(path = "/todo/{id}")
    public TodoDto getTodo(@PathVariable Long id) {

        return todoService.findById(id);
    }


    @PostMapping(path = "/todo")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto) {

        //I put username hardcore for the moment then it will be put by frontend
        todoDto.setUsername("username");
        return ResponseEntity.ok(todoService.createTodo(todoDto));
    }

    /*
        for post, we give back the Url of the new resource created


    @PostMapping(path = "/todo")
    public ResponseEntity<Void> createTodo2(@RequestBody TodoDto todoDto) {

        TodoDto todoDtoCrreated = todoService.createTodo(todoDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(todoDtoCrreated.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }
    */

    @PutMapping(path = "/todo")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto) {

        return ResponseEntity.ok(todoService.updateTodo(todoDto));
    }

    @DeleteMapping(path = "/todo/{id}")
    public void deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);
    }

    @GetMapping(path = "/username/{username}/todos")
    public ResponseEntity<List<TodoDto>> getAllTodos(@PathVariable String username) {

        return ResponseEntity.ok(todoService.findAll(username));
    }
}
