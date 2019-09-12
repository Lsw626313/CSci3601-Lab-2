package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class SortTodos {

  @Test
  public void sortTodo() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] sortTodoByOwner = db.sortTodos(allTodos, "owner");
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[0].owner);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[32].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[284].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[299].owner);

    Todo[] sortTodoByStatus = db.sortTodos(allTodos, "status");
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[0].status);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[32].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[284].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[299].status);

    Todo[] sortTodoByCategory = db.sortTodos(allTodos, "category");
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[0].category);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[32].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[284].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[299].category);
  }

  @Test
  public void ListTodoBySortFactor() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("orderBy", new String[]{"owner"});
    Todo[] sortTodoByOwner = db.listTodos(queryParams);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[0].owner);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[32].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[284].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[299].owner);

    queryParams.put("orderBy", new String[]{"status"});
    Todo[] sortTodoByStatus = db.listTodos(queryParams);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[0].status);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[32].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[284].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[299].status);

    queryParams.put("orderBy", new String[]{"category"});
    Todo[] sortTodoByCategory = db.listTodos(queryParams);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[0].category);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[32].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[284].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[299].category);
  }
}
