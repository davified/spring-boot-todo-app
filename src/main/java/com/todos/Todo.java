package com.todos;

public class Todo {
  private final long id;
  private final String body;
  private final String category;

  public Todo(long id, String body, String category) {
    this.id = id;
    this.body = body;
    this.category = category;
  }

  @Override
  public String toString() {
    return String.format("Todo{id=%d, body='%s', category='%s'}", id, body, category);
  }

  public long getId() {
    return id;
  }

  public String getBody() {
    return body;
  }

  public String getCategory() {
    return category;
  }
}
