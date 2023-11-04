package com.todoapp.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.demo.bean.ToDoList;

public interface ToDoRepository extends JpaRepository<ToDoList, Integer>{

	
	public List<ToDoList> findByUsername(String username);
}
