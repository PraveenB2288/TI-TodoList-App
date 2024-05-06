package com.telus.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.todo.model.Todo;
import com.telus.todo.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
    	Optional<Todo> optionalTodo = todoRepository.findById(id);
        return optionalTodo.orElse(null);
    }

    @Override
    public Todo createTodo(Todo todo) {
        // You can implement validation logic here if needed
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo existingTodo = optionalTodo.orElse(null);
        if (existingTodo != null) {
            // Update existingTodo properties with the new todo object
            existingTodo.setDescription(todo.getDescription());
            existingTodo.setCompleted(todo.getCompleted());
            return todoRepository.save(existingTodo);
        }
        return null;
    }

    @Override
    public boolean deleteTodo(Long id) {
    	try {
            todoRepository.deleteById(id);
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }
}
