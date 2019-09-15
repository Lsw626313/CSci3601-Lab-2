package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoByBodyContent {

  @Test
  public void filterTodoByBodyContent() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] veniamTodos = db.filterTodosByStrContained(allTodos, "veniam");
    assertEquals("Incorrect number of veniam todos", 70, veniamTodos.length);
    assertEquals("Incorrect id of veniam todos", "58895985c1849992336c219b", veniamTodos[0]._id);
    assertEquals("Incorrect id of veniam todos", "588959856b2259d62afcebf4", veniamTodos[69]._id);

    Todo[] exercitationTodo = db.filterTodosByStrContained(allTodos, "exercitation");
    assertEquals("Incorrect number of exercitation todos", 87, exercitationTodo.length);
    assertEquals("Incorrect id of exercitation todos", "58895985186754887e0381f5", exercitationTodo[0]._id);
    assertEquals("Incorrect id of exercitation todos", "588959856b2259d62afcebf4", exercitationTodo[86]._id);

    Todo[] unknownTodo = db.filterTodosByStrContained(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }

  @Test
  public void ListTodoByBodyFactor() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String,String[]> queryParams = new HashMap<>();

    queryParams.put("contains", new String[]{"veniam"});
    Todo[] veniamTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of veniam todos", 70, veniamTodos.length);
    assertEquals("Incorrect id of veniam todos", "58895985c1849992336c219b", veniamTodos[0]._id);
    assertEquals("Incorrect id of veniam todos", "588959856b2259d62afcebf4", veniamTodos[69]._id);

    queryParams.put("contains", new String[]{"exercitation"});
    Todo[] exercitationTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of exercitation todos", 87, exercitationTodo.length);
    assertEquals("Incorrect id of exercitation todos", "58895985186754887e0381f5", exercitationTodo[0]._id);
    assertEquals("Incorrect id of exercitation todos", "588959856b2259d62afcebf4", exercitationTodo[86]._id);

    queryParams.put("contains", new String[]{"UNKNOWN"});
    Todo[] unknownTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }
}
