package com.fvthree.springbootoktastarter.todo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fvthree.springbootoktastarter.exception.AbstractController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class TodoController extends AbstractController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todo")
	public ResponseEntity<?> createTodo(@Valid @RequestBody CreateTodoRequest req) {
		boolean result = todoService.createTodo(req);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/todo")
    public TodoPagedResponse getAllTodos(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "createdDate", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "desc", required = false) String sortDir) {
        log.info(" size ::: " + pageSize + ", number ::: " + pageNo + ", sortBy ::: " + sortBy + ", sortDir ::: " + sortDir);
        return todoService.list(pageNo, pageSize, sortBy, sortDir);
    }
}
