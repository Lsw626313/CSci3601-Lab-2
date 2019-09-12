package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByOwner {

  @Test
  public void filterTodoByOwner() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] blancheTodo = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Incorrect number of todos with owner Blanche", 43, blancheTodo.length);

    Todo[] robertaTodos = db.filterTodosByOwner(allTodos, "Roberta");
    assertEquals("Incorrect number of todos with owner Roberta", 46, robertaTodos.length);

    Todo[] unknownTodos = db.filterTodosByOwner(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of todos with owner UNKNOWN", 0, unknownTodos.length);
  }

  @Test
  public void ListTodoByOwnerFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[]{"Blanche"});
    Todo[] noTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner Blanche", 43, noTodo.length);

    queryParams.put("owner", new String[]{"Roberta"});
    Todo[] robertaTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner Roberta", 46, robertaTodos.length);

    queryParams.put("owner", new String[]{"UNKNOWN"});
    Todo[] unknownTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner UNKNOWN", 0, unknownTodos.length);
  }
}
