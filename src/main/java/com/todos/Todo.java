package com.todos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // this indicates that this class is a JPA entity. it is assumed that this entity will be mapped to a table named "to_do".
public class Todo {
  @Id //This annotation allows JPA to recognize it as the object’s ID
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String body;
  private String category;

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return String.format("Todo{id=%d, body='%s', category='%s'}", id, body, category);
  }
}
