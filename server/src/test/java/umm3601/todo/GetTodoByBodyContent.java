package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoByBodyContent {

  @Test
  public void filterTodoByBodyContent() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] veniamTodos = db.filterTodosByStrContained(allTodos, "veniam");
    assertEquals("Incorrect number of veniam todos", 70, veniamTodos.length);

    Todo[] exercitationTodo = db.filterTodosByStrContained(allTodos, "exercitation");
    assertEquals("Incorrect number of exercitation todos", 87, exercitationTodo.length);

    Todo[] unknownTodo = db.filterTodosByStrContained(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }

  @Test
  public void ListTodoByBodyFactor() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String,String[]> queryParams = new HashMap<>();

    queryParams.put("contains", new String[]{"veniam"});
    Todo[] veniamTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of veniam todos", 70, veniamTodos.length);

    queryParams.put("contains", new String[]{"exercitation"});
    Todo[] exercitationTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of exercitation todos", 87, exercitationTodo.length);

    queryParams.put("contains", new String[]{"UNKNOWN"});
    Todo[] unknownTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }
}
