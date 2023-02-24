package com.fvthree.springbootoktastarter.todo;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CreateTodoRequest {
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
}
