package com.nacrosolution.todo.dao;

import java.util.List;

import com.nacrosolution.todo.model.Todo;



public interface TodoDAO {
	public List<Todo> getTodo();
    
    public void createTodo(Todo todo);
    public Todo findById(int theId);
    public Todo getTodo(int todoId);
    public void deleteTodo(int todoId);
}
