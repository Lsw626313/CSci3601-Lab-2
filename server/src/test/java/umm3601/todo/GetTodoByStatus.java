package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoByStatus {

  @Test
  public void filterTodoByStatus() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] completeTodos = db.filterTodosByStatus(allTodos, "complete");
    assertEquals("Incorrect number of complete todos", 143, completeTodos.length);
    assertEquals("Incorrect id of complete todos", "58895985ae3b752b124e7663", completeTodos[0]._id);
    assertEquals("Incorrect id of complete todos", "58895985a69d6afde00af172", completeTodos[142]._id);

    Todo[] incompleteTodo = db.filterTodosByStatus(allTodos, "incomplete");
    assertEquals("Incorrect number of incomplete todos", 157, incompleteTodo.length);
    assertEquals("Incorrect id of incomplete todos", "58895985a22c04e761776d54", incompleteTodo[0]._id);
    assertEquals("Incorrect id of incomplete todos", "58895985f0a4bbea24084abf", incompleteTodo[156]._id);

    Todo[] unknownTodo = db.filterTodosByStatus(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }

  @Test
  public void ListTodoByStatusFactor() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String,String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[]{"complete"});
    Todo[] completeTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of complete todos", 143, completeTodos.length);
    assertEquals("Incorrect id of complete todos", "58895985ae3b752b124e7663", completeTodos[0]._id);
    assertEquals("Incorrect id of complete todos", "58895985a69d6afde00af172", completeTodos[142]._id);

    queryParams.put("status", new String[]{"incomplete"});
    Todo[] incompleteTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of incomplete todos", 157, incompleteTodo.length);
    assertEquals("Incorrect id of incomplete todos", "58895985a22c04e761776d54", incompleteTodo[0]._id);
    assertEquals("Incorrect id of incomplete todos", "58895985f0a4bbea24084abf", incompleteTodo[156]._id);

    queryParams.put("status", new String[]{"UNKNOWN"});
    Todo[] unknownTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }
}
