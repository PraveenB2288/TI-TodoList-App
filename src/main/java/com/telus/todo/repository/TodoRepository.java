package com.telus.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telus.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

	List<Todo> findAll();
	//Todo findById(Long id);
	Todo save(Todo todo);
	//void delete(int id);
	    
}
