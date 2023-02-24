package com.fvthree.springbootoktastarter.todo;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long>{
	boolean existsByTitle(String title);
}
