package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoArbitraryFactors {

  @Test
  public void ListTodoByArbitraryBarry() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();
    queryParams.put("category", new String[]{"homework"});
    queryParams.put("owner", new String[]{"Barry"});
    queryParams.put("status", new String[]{"complete"});
    queryParams.put("limit", new String[]{"7"});
    Todo[] arbitraryBarryTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of arbitrary todos", 7, arbitraryBarryTodos.length);
    assertEquals("Incorrect id of arbitrary todos", "58895985847a6c1445ec4048", arbitraryBarryTodos[0]._id);
    assertEquals("Incorrect id of arbitrary todos", "58895985493c0e01e63574e9", arbitraryBarryTodos[6]._id);
  }

  @Test
  public void ListTodoByArbitraryFry() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();
    queryParams.put("owner", new String[]{"Fry"});
    queryParams.put("contains", new String[]{"amet"});
    queryParams.put("orderBy", new String[]{"body"});
    queryParams.put("category", new String[]{"video games"});
    Todo[] arbitraryFryTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of arbitrary todos", 9, arbitraryFryTodo.length);
    assertEquals("Incorrect id of arbitrary todos", "58895985ba6d35a801f171ac", arbitraryFryTodo[0]._id);
    assertEquals("Incorrect id of arbitrary todos", "58895985d4efc8658ba2df46", arbitraryFryTodo[8]._id);

  }

  @Test
  public void ListTodoByArbitraryNull() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();
    queryParams.put("owner", new String[]{"Fry"});
    queryParams.put("contains", new String[]{"homework"});
    queryParams.put("orderBy", new String[]{"body"});
    queryParams.put("limit", new String[]{"10"});
    Todo[] arbitraryNullTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of arbitrary todos", 0, arbitraryNullTodo.length);
  }
}
