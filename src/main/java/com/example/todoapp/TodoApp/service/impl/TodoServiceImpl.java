package com.example.todoapp.TodoApp.service.impl;

import com.example.todoapp.TodoApp.model.Todo;
import com.example.todoapp.TodoApp.repository.TodoRepository;
import com.example.todoapp.TodoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Todo foundTodo = todoRepository.findById(id).get();

        foundTodo.setTitle(todo.getTitle());
        foundTodo.setDescription(todo.getDescription());
        foundTodo.setCompleted(todo.isCompleted());

        return todoRepository.save(foundTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
