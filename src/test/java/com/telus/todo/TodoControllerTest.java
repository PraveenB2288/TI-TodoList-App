package com.telus.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.telus.todo.controller.TodoController;
import com.telus.todo.model.Todo;
import com.telus.todo.service.TodoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TodoControllerTest {

    @InjectMocks
    private TodoController todoController;

    @Mock
    private TodoService todoService;

    Todo todo;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        todo = new Todo();
        todo.setId(1L);        
        todo.setDescription("Complete TI Assignments");
        todo.setCompleted(true);
    }

    @Test
    public void testGetAllTodos() {
    	List<Todo> todos = new ArrayList<>();
        todos.add(todo);

        when(todoService.getAllTodos()).thenReturn(todos);

        ResponseEntity<List<Todo>> responseEntity =  todoController.getAllTodos();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(todos, responseEntity.getBody());
    }

    @Test
    public void testGetTodoById() {
        //Todo todo = new Todo(1L, "Todo", "Description");

        when(todoService.getTodoById(1L)).thenReturn(todo);

        ResponseEntity<Todo> responseEntity = todoController.getTodoById(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(todo, responseEntity.getBody());
    }
}
