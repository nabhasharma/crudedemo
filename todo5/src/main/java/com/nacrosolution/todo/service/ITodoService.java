package com.nacrosolution.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.nacrosolution.todo.model.Todo;

public interface ITodoService {

public List<Todo> getTodo();
    
    public void createTodo(Todo todo);
    public Todo findById(int theId);
    public Todo getTodo(int todoId);
    public void deleteTodo(int todoId);
}