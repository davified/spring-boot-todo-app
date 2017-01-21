package com.todos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos") //  this is not necessary unless you are defining custom endpoints that have a different name from your model
public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findByCategory(@Param("category") String category);
  //  usage: http://localhost:8080/todos/search/findByCategory?category=cooking
}
