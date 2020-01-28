package com.example.todos.controller;


import com.example.todos.dto.TodoDto;
import com.example.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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
    public TodoDto createTodo(@RequestBody TodoDto todoDto) {

        return todoService.createTodo(todoDto);
    }

    @PutMapping(path ="/todo")
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
