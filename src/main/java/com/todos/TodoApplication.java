package com.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = Todo.class)
public class TodoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoApplication.class, args);
  }
}
