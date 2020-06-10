package com.nacrosolution.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nacrosolution.todo.dao.TodoDAO;
import com.nacrosolution.todo.model.Todo;


@Service
public class TodoService implements ITodoService {

	
	private TodoDAO todoDAO;
	
	
	   public TodoService() {
		   
	    }
	   
	   
	   
	public TodoService(TodoDAO todoDAO) {
		
		this.todoDAO = todoDAO;
	}



	@Override
	public List<Todo> getTodo() {
		// TODO Auto-generated method stub
		return todoDAO.getTodo();
	}

	@Override
	public void createTodo(Todo todo) {
		todoDAO.createTodo(todo);
		
	}

	@Override
	public Todo findById(int theId) {
	
		return todoDAO.findById(theId);
	}

	@Override
	public Todo getTodo(int todoId) {
		// TODO Auto-generated method stub
		return todoDAO.getTodo(todoId); 
	}

	@Override
	public void deleteTodo(int todoId) {
		// TODO Auto-generated method stub
		todoDAO.deleteTodo(todoId);
	}

	
}