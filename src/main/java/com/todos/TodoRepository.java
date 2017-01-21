package com.todos;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long> {

  List<Todo> findByCategory(@Param("category") String category);

}
