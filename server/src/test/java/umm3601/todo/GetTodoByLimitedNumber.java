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
    assertEquals("Incorrect id of todos with limit 100", "58895985a22c04e761776d54", aHundredTodos[0]._id);
    assertEquals("Incorrect id of todos with limit 100", "5889598504f1c08ba942bddf", aHundredTodos[99]._id);

    Todo[] fourHundredTodos = db.filterTodosByLimit(allTodos, 400);
    assertEquals("Incorrect number of todos with limit 400", 300, fourHundredTodos.length);
    assertEquals("Incorrect id of todos with age 400", "58895985a22c04e761776d54", fourHundredTodos[0]._id);
    assertEquals("Incorrect id of todos with age 400", "58895985f0a4bbea24084abf", fourHundredTodos[299]._id);
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
    assertEquals("Incorrect owner of todos with limit 100", "Fry", aHundredTodos[99].owner);
    assertEquals("Incorrect id of todos with limit 100", "58895985a22c04e761776d54", aHundredTodos[0]._id);
    assertEquals("Incorrect id of todos with limit 100", "5889598504f1c08ba942bddf", aHundredTodos[99]._id);

    queryParams.put("limit", new String[]{"400"});
    Todo[] fourHundredTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with age 400", 300, fourHundredTodos.length);
    assertEquals("Incorrect owner of todos with age 400", "Barry", fourHundredTodos[299].owner);
    assertEquals("Incorrect id of todos with age 400", "58895985a22c04e761776d54", fourHundredTodos[0]._id);
    assertEquals("Incorrect id of todos with age 400", "58895985f0a4bbea24084abf", fourHundredTodos[299]._id);
  }
}
