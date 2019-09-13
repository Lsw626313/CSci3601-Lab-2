package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoArbitrary {

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
    assertEquals("Incorrect body of arbitrary todos", "Magna elit aliqua dolor ad amet irure ullamco qui consectetur elit. Excepteur nisi id dolore voluptate laborum.", arbitraryBarryTodos[6].body);
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
    assertEquals("Incorrect body of arbitrary todos", "Reprehenderit adipisicing consectetur culpa aliquip eiusmod proident anim. Commodo aliqua amet reprehenderit esse sit elit officia fugiat nulla aute elit ea excepteur anim.", arbitraryFryTodo[7].body);

  }
}
