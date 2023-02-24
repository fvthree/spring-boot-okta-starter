package com.fvthree.springbootoktastarter.todo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fvthree.springbootoktastarter.exception.HTTP400Exception;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class TodoServiceImpl implements TodoService {

	@Autowired
	private final TodoRepository todoRepository;

	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public boolean createTodo(CreateTodoRequest request) {
		
		if (todoRepository.existsByTitle(request.getTitle())) {
			throw new HTTP400Exception("title already exists");
		}
		
		Todo newTodo = Todo.builder()
				.title(request.getTitle())
				.description(request.getDescription())
				.build();
		
		todoRepository.save(newTodo);
		return true;
	}

	@Override
	public TodoPagedResponse list(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Todo> todos = todoRepository.findAll(pageable);

		List<Todo> content = todos.getContent();

		TodoPagedResponse todoResponse = TodoPagedResponse.builder()
				.content(content)
				.pageNo(todos.getNumber())
				.pageSize(todos.getSize())
				.totalElements(todos.getTotalElements())
				.totalPages(todos.getTotalPages())
				.last(todos.isLast())
				.build();

		return todoResponse;
	}

}
