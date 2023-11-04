package com.todoapp.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.todoapp.demo.bean.ToDoList;

@Service
public class ToDoService {
	
	static int cnt = 0;

	private static List<ToDoList> todo = new ArrayList<>();
	
	static {
		todo.add(new ToDoList(++cnt,"Nikhil", "Learn AWS", LocalDate.now().plusYears(1), false));
		todo.add(new ToDoList(++cnt,"Nikhil", "Learn DevOps", LocalDate.now().plusMonths(3),false));
		todo.add(new ToDoList(++cnt, "Nikhil", "Learn Spring & SpringBoot", LocalDate.now().plusDays(20),false));
	}
	
	public List<ToDoList> findByUsername(String username){
		Predicate<? super ToDoList> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todo.stream().filter(predicate).collect(Collectors.toList());
	}
	
	public void addTodo(String username, String description, LocalDate date, boolean done) {
		ToDoList todos = new ToDoList(++cnt,  username, description, date, done);
		todo.add(todos);
		cnt++;
	}
	
	public void deleteById(int id) {
		Predicate<? super ToDoList> predicate = todo -> todo.getId() == id;
		todo.removeIf(predicate);
	}

	public ToDoList findById(int id) {
		Predicate<? super ToDoList> predicate = todo -> todo.getId() == id;
		ToDoList toDoList = todo.stream().filter(predicate).findFirst().get();
		return toDoList;
	}

	public void updateTodo(@Valid ToDoList todos) {
		deleteById(todos.getId());
		todo.add(todos);
		
	}
}
