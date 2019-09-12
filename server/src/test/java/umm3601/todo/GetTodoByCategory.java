package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoByCategory {

  @Test
  public void filterTodoByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[]homeworkTodos = db.filterTodosByCategory(allTodos, "homework");
    assertEquals("Incorrect number of homework todos", 79, homeworkTodos.length);

    Todo[] videoGamesTodo = db.filterTodosByCategory(allTodos, "video games");
    assertEquals("Incorrect number of videoGames todos", 71, videoGamesTodo.length);

    Todo[] unknownTodo = db.filterTodosByCategory(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }

  @Test
  public void ListTodoByCategoryFactor() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String,String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[]{"homework"});
    Todo[] homeworkTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of homework todos", 79, homeworkTodos.length);

    queryParams.put("category", new String[]{"video games"});
    Todo[] videoGamesTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of videoGames todos", 71, videoGamesTodo.length);

    queryParams.put("category", new String[]{"UNKNOWN"});
    Todo[] unknownTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }
}
