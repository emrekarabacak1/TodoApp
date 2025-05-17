package com.example.todoapp.TodoApp.repository;

import com.example.todoapp.TodoApp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
