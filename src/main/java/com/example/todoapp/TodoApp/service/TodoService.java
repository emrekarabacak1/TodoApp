package com.example.todoapp.TodoApp.service;

import com.example.todoapp.TodoApp.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getTodoList();
    Optional<Todo> getTodoById(Long id);
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id,Todo todo);
    void deleteTodo(Long id);
}
