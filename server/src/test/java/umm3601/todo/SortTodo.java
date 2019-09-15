package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class SortTodo {

  @Test
  public void sortTodo() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] sortTodoByOwner = db.sortTodos(allTodos, "owner");
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[0].owner);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[1].owner);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[2].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[297].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[298].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[299].owner);

    Todo[] sortTodoByBody = db.sortTodos(allTodos, "body");
    assertEquals("Incorrect sorting of todos in body", "Ad sint incididunt officia veniam incididunt. Voluptate exercitation eu aliqua laboris occaecat deserunt cupidatat velit nisi sunt mollit sint amet.", sortTodoByBody[0].body);
    assertEquals("Incorrect sorting of todos in body", "Ad sit Lorem magna consectetur ut sit sunt aliquip. Ullamco quis quis commodo irure do nostrud anim sit commodo consequat.", sortTodoByBody[1].body);
    assertEquals("Incorrect sorting of todos in body", "Adipisicing anim ad sunt esse consectetur ipsum sint fugiat. Et minim nulla id amet.", sortTodoByBody[2].body);
    assertEquals("Incorrect sorting of todos in body", "Voluptate et tempor amet proident nisi cupidatat aute consectetur elit deserunt occaecat est tempor. Ullamco aliqua quis excepteur ad deserunt labore sit tempor dolore ipsum ut aute nostrud.", sortTodoByBody[297].body);
    assertEquals("Incorrect sorting of todos in body", "Voluptate mollit laboris ipsum veniam non id pariatur amet. Enim id irure est amet veniam ipsum.", sortTodoByBody[298].body);
    assertEquals("Incorrect sorting of todos in body", "Voluptate sit velit occaecat pariatur. Qui adipisicing ipsum incididunt laborum.", sortTodoByBody[299].body);

    Todo[] sortTodoByStatus = db.sortTodos(allTodos, "status");
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[0].status);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[1].status);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[2].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[297].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[298].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[299].status);

    Todo[] sortTodoByCategory = db.sortTodos(allTodos, "category");
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[0].category);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[1].category);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[2].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[297].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[298].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[299].category);
  }

  @Test
  public void ListTodoBySortFactor() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("orderBy", new String[]{"owner"});
    Todo[] sortTodoByOwner = db.listTodos(queryParams);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[0].owner);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[1].owner);
    assertEquals("Incorrect sorting of todos in owner", "Barry", sortTodoByOwner[2].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[297].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[298].owner);
    assertEquals("Incorrect sorting of todos in owner", "Workman", sortTodoByOwner[299].owner);

    queryParams.put("orderBy", new String[]{"body"});
    Todo[] sortTodoByBody = db.listTodos(queryParams);
    assertEquals("Incorrect sorting of todos in body", "Ad sint incididunt officia veniam incididunt. Voluptate exercitation eu aliqua laboris occaecat deserunt cupidatat velit nisi sunt mollit sint amet.", sortTodoByBody[0].body);
    assertEquals("Incorrect sorting of todos in body", "Ad sit Lorem magna consectetur ut sit sunt aliquip. Ullamco quis quis commodo irure do nostrud anim sit commodo consequat.", sortTodoByBody[1].body);
    assertEquals("Incorrect sorting of todos in body", "Adipisicing anim ad sunt esse consectetur ipsum sint fugiat. Et minim nulla id amet.", sortTodoByBody[2].body);
    assertEquals("Incorrect sorting of todos in body", "Voluptate et tempor amet proident nisi cupidatat aute consectetur elit deserunt occaecat est tempor. Ullamco aliqua quis excepteur ad deserunt labore sit tempor dolore ipsum ut aute nostrud.", sortTodoByBody[297].body);
    assertEquals("Incorrect sorting of todos in body", "Voluptate mollit laboris ipsum veniam non id pariatur amet. Enim id irure est amet veniam ipsum.", sortTodoByBody[298].body);
    assertEquals("Incorrect sorting of todos in body", "Voluptate sit velit occaecat pariatur. Qui adipisicing ipsum incididunt laborum.", sortTodoByBody[299].body);

    queryParams.put("orderBy", new String[]{"status"});
    Todo[] sortTodoByStatus = db.listTodos(queryParams);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[0].status);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[1].status);
    assertFalse("Incorrect sorting of todos in status", sortTodoByStatus[2].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[297].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[298].status);
    assertTrue("Incorrect sorting of todos in status", sortTodoByStatus[299].status);

    queryParams.put("orderBy", new String[]{"category"});
    Todo[] sortTodoByCategory = db.listTodos(queryParams);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[0].category);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[1].category);
    assertEquals("Incorrect sorting of todos in category", "groceries", sortTodoByCategory[2].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[297].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[298].category);
    assertEquals("Incorrect sorting of todos in category", "video games", sortTodoByCategory[299].category);
  }
}
