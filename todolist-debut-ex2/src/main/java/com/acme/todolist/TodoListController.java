package com.acme.todolist;

import java.util.List;

import javax.inject.Inject;

import com.acme.todolist.application.port.in.AddTodoItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 *
 * @author bflorat
 * edit Leo and Etienne
 */
@RestController
public class TodoListController {

	private final GetTodoItems getTodoItemsQuery;
	private final AddTodoItem addTodoItemCommand;

	@Inject
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItem addTodoItemCommand) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.addTodoItemCommand = addTodoItemCommand;
	}

	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}

	@PostMapping("/todos")
	@ResponseStatus(HttpStatus.CREATED)
	public void ajouterItem(@RequestBody TodoItem item) {
		this.addTodoItemCommand.addTodoItem(item);
	}
}
