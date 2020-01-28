package com.example.todos.dto.mapper;


import com.example.todos.dto.TodoDto;
import com.example.todos.model.Todo;
import org.mapstruct.Mapper;


@Mapper
public interface TodoDtoMapper {

    TodoDto intoDto(Todo todo);

    Todo intoEnt(TodoDto todoDto);
}
