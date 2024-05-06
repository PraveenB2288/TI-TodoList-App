package com.telus.todo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.telus.todo.model.Todo;
import com.telus.todo.repository.TodoRepository;
import com.telus.todo.service.TodoService;
import com.telus.todo.service.TodoServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

	@InjectMocks
    private TodoServiceImpl todoService;

    @Mock
    private TodoRepository todoRepository;

    private Todo todo;

    @BeforeEach
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        todo = new Todo();
        todo.setId(1L);        
        todo.setDescription("Complete TI Assignments");
        todo.setCompleted(true);
    }

    @Test
    public void testFindAll() {
        List<Todo> todos = new ArrayList<>();
        todos.add(todo);

        when(todoRepository.findAll()).thenReturn(todos);

        List<Todo> result = todoService.getAllTodos();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(todo);
    }

    @Test
    public void testFindById() {
        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        Todo result = todoService.getTodoById(1L);

        assertThat(result != null).isTrue();
        assertThat(result).isEqualTo(todo);
    }

    @Test
    public void testSave() {
        when(todoRepository.save(todo)).thenReturn(todo);

        Todo savedTodo = todoService.createTodo(todo);

        assertThat(savedTodo).isNotNull();
        assertThat(savedTodo.getId()).isEqualTo(1L);
        assertThat(savedTodo.getCompleted()).isEqualTo(true);
        assertThat(savedTodo.getDescription()).isEqualTo("Complete TI Assignments");
    }

    @Test
    public void testDelete() {
        boolean result = todoService.deleteTodo(1L);
        assertThat(result).isTrue();
    }
}
