package com.todos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TodoController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "Welcome to the todo app";
  }

  @RequestMapping("todos")
  public List<Todo> index() {
    Todo todo1 = new Todo(1, "buy milk", "groceries");
    Todo todo2 = new Todo(2, "buy apples", "groceries");
    Todo todo3 = new Todo(3, "buy pears", "groceries");
    return Arrays.asList(todo1, todo2, todo3);
  }
}
