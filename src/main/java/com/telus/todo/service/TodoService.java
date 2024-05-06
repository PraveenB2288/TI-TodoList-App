package com.telus.todo.service;

import java.util.List;

import com.telus.todo.model.Todo;

public interface TodoService {

	public List<Todo> getAllTodos();

    public Todo getTodoById(Long id) ;

    public Todo createTodo(Todo todo);

    public Todo updateTodo(Long id, Todo todo);

    public boolean deleteTodo(Long id) ;
}
