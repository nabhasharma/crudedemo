package com.nacrosolution.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nacrosolution.todo.model.Todo;
import com.nacrosolution.todo.service.ITodoService;


@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private ITodoService todoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	public TodoController(ITodoService todoService) {
		this.todoService = todoService;
	}
	
	
	

    @RequestMapping(value="/listTodos",method = RequestMethod.GET)
    public String listCustomer(Model model) {
        model.addAttribute("todos",todoService.getTodo());
        return "todo";

    }
    @RequestMapping(value="/showFormForAdd",method = RequestMethod.GET)
    public String showFormForAdd(Model model)
    {
        model.addAttribute("todo",new Todo());
        return "todo-form";
    }
   
    
    
    @RequestMapping(value="/saveTodo",method = RequestMethod.GET)
    public String saveCustomer(@Valid @ModelAttribute("customer") Todo todo, BindingResult theBindingResult)
    {
    	
    	System.out.println("First name: |" + todo.getUserName()  + "|");
		
		if (theBindingResult.hasErrors()) {
			return "todo-form";
		}
		else {
			 todoService.createTodo(todo);
		     return "redirect:/todo/listTodos";
		}
    	
       
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {

        // get the customer from our service
        Todo theTodo = todoService.getTodo(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("todo", theTodo);

        // send over to our form
        return "todo-form";
    }
    
    
   
    
    
    @RequestMapping(value="/updateTodo",method = RequestMethod.GET)
    public String updateCustomer(@ModelAttribute("todo") Todo todo)
    {
    	todoService.createTodo(todo);
    	return "redirect:/todo/listTodos";
    }
    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("TodoId") int todoId)
    {
    	todoService.deleteTodo(todoId);
    	return "redirect:/todo/listTodos";
    }
}
