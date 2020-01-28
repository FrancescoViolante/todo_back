package com.example.todos.service;


import com.example.todos.dto.TodoDto;

import java.util.List;


public interface TodoService {

    TodoDto findById(Long id);

    TodoDto createTodo(TodoDto todo);

    TodoDto updateTodo(TodoDto todo);

    void deleteTodo(Long id);

    List<TodoDto> findAll(String username);
}
