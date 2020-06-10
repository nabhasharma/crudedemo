package com.nacrosolution.todo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nacrosolution.todo.model.Todo;






@Repository("customerDAO")
public class TodoDAOImpl implements TodoDAO {
    private final EntityManager entityManager;

    @Autowired
    public TodoDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;

    }

    @Override
    @Transactional
    public List<Todo> getTodo() {
        Query query = entityManager.createQuery("from Customer");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createTodo(Todo todo) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
      //  session.getTransaction().begin();
        session.saveOrUpdate(todo);
        //session.getTransaction().commit();


    }

  
    @Override
    @Transactional
    public void deleteTodo(int todoId) {
        entityManager.remove(getTodo(todoId));

    }

	@Override
	@Transactional
	public Todo findById(int theId)
	{
		// get he current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		//get the Employeee
		
		Todo theTodo=currentSession.get(Todo.class, theId);
		//return employee
		return theTodo;
	}

	  @Override
	    @Transactional
	    public Todo getTodo(int todoId) {
	        return entityManager.find(Todo.class,todoId);
	    }

	


}


