package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class GetTodoByStatus {

  @Test
  public void sortTodo() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] completeTodos = db.filterTodosByStatus(allTodos, "complete");
    assertEquals("Incorrect number of complete todos", 143, completeTodos.length);

    Todo[] incompleteTodo = db.filterTodosByStatus(allTodos, "incomplete");
    assertEquals("Incorrect number of incomplete todos", 157, incompleteTodo.length);

    Todo[] unknownTodo = db.filterTodosByStatus(allTodos, "UNKNOWN");
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }

  @Test
  public void ListTodoBySortFactor() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String,String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[]{"complete"});
    Todo[] completeTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of complete todos", 143, completeTodos.length);

    queryParams.put("status", new String[]{"incomplete"});
    Todo[] incompleteTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of incomplete todos", 157, incompleteTodo.length);

    queryParams.put("status", new String[]{"UNKNOWN"});
    Todo[] unknownTodo = db.listTodos(queryParams);
    assertEquals("Incorrect number of UNKNOWN todos", 0, unknownTodo.length);
  }
}
