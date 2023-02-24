package com.fvthree.springbootoktastarter.todo;

public interface TodoService {
	boolean createTodo(CreateTodoRequest todo);
	TodoPagedResponse list(int pageNo, int pageSize, String sortBy, String sortDir);
}
