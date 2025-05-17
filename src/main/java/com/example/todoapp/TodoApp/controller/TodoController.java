package com.example.todoapp.TodoApp.controller;

import com.example.todoapp.TodoApp.model.Todo;
import com.example.todoapp.TodoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(createdTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, Todo todo) {
        if(!todoService.getTodoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Todo updated = todoService.updateTodo(id,todo);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        if(!todoService.getTodoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
