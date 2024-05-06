package com.telus.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telus.todo.model.Todo;
import com.telus.todo.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = { "Todo List App API" }, produces = "application/json")
@RequestMapping(path = "/todos", produces = "application/json")
public class TodoController {
	
    @Autowired
    private TodoService todoService;
    
    @ApiOperation(value = "List or Find Todo Item objects", nickname = "retrieveTodoItems", 
    		notes = "This operation lists or finds Todo Items", 
    		response = Todo.class, responseContainer = "List", 
    		tags = {"TodoItem", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "", response = Todo.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@GetMapping(value = "", produces = { "application/json" })
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
    }

    @ApiOperation(value = "Retrieve a Todo item by Id", nickname = "retrieveTodoItemById", 
    		notes = "API to retrieve a Todo Item by Id", 
    		response = Todo.class, 
    		tags = {"TodoItem", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Todo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(todo);
    }

    @ApiOperation(value = "Create a Todo item", nickname = "createTodoItem", 
    		notes = "This operation creates a service Todo Item", 
    		response = Todo.class, 
    		tags = { "TodoItem", })
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Todo.class),
			@ApiResponse(code = 202, message = "Accepted", response = Error.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @PostMapping(produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<Todo> createTodo(
    		@ApiParam(value = "The service to be created.") @RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @ApiOperation(value = "Update a Todo list item by id", nickname = "updateTodoItem", 
    		notes = "This operation performs partial update to a Todo Item", 
    		response = Todo.class, 
    		tags = {"TodoItem", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Todo item is updated.", response = Todo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })    
    @PatchMapping(value = "/{id}", produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<Todo> updateTodo(
    		@ApiParam(value = "Todo Item Id", required = true) @PathVariable Long id, 
    		@ApiParam(value = "The Item to be updated..") @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        if (updatedTodo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedTodo);
    }

    @ApiOperation(value = "Deletes a Todo item", nickname = "deleteTodoItem", 
    		notes = "This operation delete a Todo Item", 
    		response = Object.class, 
    		tags = {"TodoItem", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Deleted", response = Object.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "", response = Error.class) })
	@DeleteMapping(value = "/{id}", produces = { "application/json" })    
    public ResponseEntity<?> deleteTodo(
    		@ApiParam(value = "Todo Item Id", required = true) @PathVariable Long id) {
        boolean deleted = todoService.deleteTodo(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
