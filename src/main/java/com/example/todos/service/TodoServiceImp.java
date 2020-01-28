package com.example.todos.service;

import com.example.todos.dto.TodoDto;
import com.example.todos.dto.mapper.TodoDtoMapper;
import com.example.todos.exception.TodoException;
import com.example.todos.model.Todo;
import com.example.todos.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TodoServiceImp implements TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private TodoDtoMapper todoDtoMapper;

    @Override
    public TodoDto findById(Long id) {

        Optional<Todo> todoDb = todoRepo.findById(id);
        if (todoDb.isPresent())
            return todoDtoMapper.intoDto(todoDb.get());
        return null;
    }

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        Todo todoDb = todoRepo.save(todoDtoMapper.intoEnt(todoDto));
        return todoDtoMapper.intoDto(todoDb);
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto) {

        Optional<Todo> todoDb = todoRepo.findById(todoDto.getId());

        if (todoDb.isPresent())
            return save(todoDto);

        throw new TodoException("Element with id " + todoDto.getId() + " not present in DB.");

    }

    private TodoDto save(TodoDto todoDto) {
        Todo todo = todoRepo.save(todoDtoMapper.intoEnt(todoDto));
        return todoDtoMapper.intoDto(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepo.deleteById(id);

    }

    //Mock service
    @Override
    public List<TodoDto> findAll(String username) {

        List<Todo> todoList = todoRepo.findAllByUsername(username);
        return todoList.stream()
                .map(todo -> todoDtoMapper.intoDto(todo)).collect(Collectors.toList());
    }
}
