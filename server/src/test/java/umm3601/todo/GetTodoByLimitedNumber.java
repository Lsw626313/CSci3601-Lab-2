package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByLimitedNumber {

  @Test
  public void filterTodoByLimit() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] emptyTodo = db.filterTodosByLimit(allTodos, 0);
    assertEquals("Incorrect number of todos with limit 0", 0, emptyTodo.length);

    Todo[] aHundredTodos = db.filterTodosByLimit(allTodos, 100);
    assertEquals("Incorrect number of todos with limit 100", 100, aHundredTodos.length);

    Todo[] fourHundredTodos = db.filterTodosByLimit(allTodos, 400);
    assertEquals("Incorrect number of todos with limit 400", 300, fourHundredTodos.length);
  }

  @Test
  public void ListTodoByLimitFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("limit", new String[]{"0"});
    Todo[] emptyTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with limit 0", 0, emptyTodo.length);

    queryParams.put("limit", new String[]{"100"});
    Todo[] aHundredTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with age 100", 100, aHundredTodos.length);

    queryParams.put("limit", new String[]{"400"});
    Todo[] fourHundredTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with age 400", 300, fourHundredTodos.length);
  }
}
