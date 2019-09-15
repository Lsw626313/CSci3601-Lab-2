package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoByCategory {

  @Test
  public void filterTodoByCategory() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[]homeworkTodos = db.filterTodosByCategory(allTodos, "homework");
    assertEquals("Incorrect number of homework todos", 79, homeworkTodos.length);
    assertEquals("Incorrect id of homework todos", "58895985ae3b752b124e7663", homeworkTodos[0]._id);
    assertEquals("Incorrect id of homework todos", "5889598516c4280a078552fe", homeworkTodos[78]._id);

    Todo[] videoGamesTodo = db.filterTodosByCategory(allTodos, "video games");
    assertEquals("Incorrect number of videoGames todos", 71, videoGamesTodo.length);
    assertEquals("Incorrect id of videoGames todos", "58895985c1849992336c219b", videoGamesTodo[0]._id);
    assertEquals("Incorrect id of videoGames todos", "5889598507bf610948f8fb64", videoGamesTodo[70]._id);

    Todo[] unknownTodo = db.filterTodosByCategory(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }

  @Test
  public void ListTodoByCategoryFactor() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String,String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[]{"homework"});
    Todo[] homeworkTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of homework todos", 79, homeworkTodos.length);
    assertEquals("Incorrect id of homework todos", "58895985ae3b752b124e7663", homeworkTodos[0]._id);
    assertEquals("Incorrect id of homework todos", "5889598516c4280a078552fe", homeworkTodos[78]._id);

    queryParams.put("category", new String[]{"video games"});
    Todo[] videoGamesTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of videoGames todos", 71, videoGamesTodo.length);
    assertEquals("Incorrect id of videoGames todos", "58895985c1849992336c219b", videoGamesTodo[0]._id);
    assertEquals("Incorrect id of videoGames todos", "5889598507bf610948f8fb64", videoGamesTodo[70]._id);

    queryParams.put("category", new String[]{"UNKNOWN"});
    Todo[] unknownTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }
}
