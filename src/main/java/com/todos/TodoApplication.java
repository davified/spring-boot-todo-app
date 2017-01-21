package com.todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(TodoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(TodoApplication.class, args);
  }

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public void run(String... args) throws Exception {
    log.info("Creating tables");

    jdbcTemplate.execute("DROP TABLE todo IF EXISTS");
    jdbcTemplate.execute("CREATE TABLE todos(" +
        "id SERIAL, body VARCHAR(255), category VARCHAR(255))");

    // Split up the array of whole names into an array of first/last names
    List<Object[]> Todos = Arrays.asList("buy apples,groceries", "buy milk,groceries", "learn spring,coding", "sleep,health").stream()
        .map(name -> name.split(","))
        .collect(Collectors.toList());

    // Use a Java 8 stream to print out each tuple of the list
    Todos.forEach(todo -> log.info(String.format("Inserting todo for %s %s", todo[0], todo[1])));

    // Uses JdbcTemplate's batchUpdate operation to bulk load data
    jdbcTemplate.batchUpdate("INSERT INTO todos(body, category) VALUES (?,?)", Todos);

    log.info("Querying for todo records where category = 'groceries':");
    jdbcTemplate.query(
        "SELECT id, body, category FROM todos WHERE category = ?", new Object[]{"groceries"},
        (rs, rowNum) -> new Todo(rs.getLong("id"), rs.getString("body"), rs.getString("category"))
    ).forEach(todo -> log.info(todo.toString()));
  }
}
