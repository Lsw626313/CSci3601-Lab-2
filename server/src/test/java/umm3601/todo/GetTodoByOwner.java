package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByOwner {

  @Test
  public void filterTodoByOwner() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] blancheTodo = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Incorrect number of todos with owner Blanche", 43, blancheTodo.length);
    assertEquals("Incorrect id of todos with owner Blanche", "58895985a22c04e761776d54", blancheTodo[0]._id);
    assertEquals("Incorrect id of todos with owner Blanche", "58895985a69d6afde00af172", blancheTodo[42]._id);

    Todo[] robertaTodos = db.filterTodosByOwner(allTodos, "Roberta");
    assertEquals("Incorrect number of todos with owner Roberta", 46, robertaTodos.length);
    assertEquals("Incorrect id of todos with owner Roberta", "58895985fac640cc6cb5f3b0", robertaTodos[0]._id);
    assertEquals("Incorrect id of todos with owner Roberta", "588959856b2259d62afcebf4", robertaTodos[45]._id);

    Todo[] unknownTodos = db.filterTodosByOwner(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of todos with owner UNKNOWN", 0, unknownTodos.length);
  }

  @Test
  public void ListTodoByOwnerFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[]{"Blanche"});
    Todo[] blancheTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner Blanche", 43, blancheTodo.length);
    assertEquals("Incorrect category of todos with owner Blanche", "software design", blancheTodo[42].category);
    assertEquals("Incorrect id of todos with owner Blanche", "58895985a22c04e761776d54", blancheTodo[0]._id);
    assertEquals("Incorrect id of todos with owner Blanche", "58895985a69d6afde00af172", blancheTodo[42]._id);

    queryParams.put("owner", new String[]{"Roberta"});
    Todo[] robertaTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner Roberta", 46, robertaTodos.length);
    assertEquals("Incorrect category of todos with owner Roberta", "groceries", robertaTodos[45].category);
    assertEquals("Incorrect id of todos with owner Roberta", "58895985fac640cc6cb5f3b0", robertaTodos[0]._id);
    assertEquals("Incorrect id of todos with owner Roberta", "588959856b2259d62afcebf4", robertaTodos[45]._id);

    queryParams.put("owner", new String[]{"UNKNOWN"});
    Todo[] unknownTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner UNKNOWN", 0, unknownTodos.length);
  }
}
