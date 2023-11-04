package com.todoapp.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todoapp.demo.bean.ToDoList;
import com.todoapp.demo.service.ToDoService;



//This class was used to get attributes/values from the static todoService class for Testing purpose,
//ToDoControllerJpa is used to retrieve data from the database...


//@Controller
@SessionAttributes("name")
public class ToDoController {

	@Autowired
	private ToDoService todoService;

	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping("/list-todo")
	public String listTodo(ModelMap model) {
		String username = getLoggedinUsername(model);
		List<ToDoList> todos = todoService.findByUsername(username);

		model.addAttribute("todo", todos);

		return "ListTodos";
	}

	@GetMapping("/add-todo")
	public String addGetTodo(ModelMap model) {
		String username = getLoggedinUsername(model);
		ToDoList todo = new ToDoList(0, username, "", LocalDate.now().plusWeeks(3), false);
		model.put("todo", todo);
		return "Todo";
	}

	// if we do not declare the modelAttribute, the command is the default keyword.
//	@GetMapping("/add-todo")
//	public String addGetTodo(ModelMap model) {
//	    String username = (String) model.get("name");
//	    ToDoList command = new ToDoList(0, username, "", LocalDate.now().plusWeeks(3), false);
//	    model.put("command", command);
//	    return "Todo";
//	}

	@PostMapping("/add-todo")
	public String addPostTodo(ModelMap model, @Valid ToDoList todo, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:add-todo";
		}
		String username = getLoggedinUsername(model);
		todoService.addTodo(username, todo.getDescription(), todo.getDate(), false);
		return "redirect:list-todo";
	}

	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todo";
	}

	@GetMapping("/update-todo")
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		ToDoList todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "Todo";
	}

	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model, @Valid ToDoList todo, BindingResult result) {
		if (result.hasErrors()) {
			return "Todo";
		}

//		String username = (String)model.get("name");
		todoService.updateTodo(todo);
		return "redirect:list-todo";
	}
}
