package umm3601.todo;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByIDFromDB {

  @Test
  public void getFryHomework() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985e96bc855be665b7d");
    assertEquals("Incorrect owner", "Fry", todo.owner);
    assertEquals("Incorrect category", "homework", todo.category);
  }

  @Test
  public void getRobertaSoftwareDesign() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo todo = db.getTodo("588959858d6f5457cb2b779f");
    assertEquals("Incorrect owner", "Roberta", todo.owner);
    assertEquals("Incorrect category", "software design", todo.category);
  }
}
