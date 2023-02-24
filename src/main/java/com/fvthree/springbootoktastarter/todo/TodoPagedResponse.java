package com.fvthree.springbootoktastarter.todo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoPagedResponse implements Serializable  {
	private static final long serialVersionUID = 5292382678051598060L;
	private List<Todo> content;
	private int pageSize;
	private int pageNo;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
