package umm3601.todo;

import com.google.gson.Gson;
import umm3601.user.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Database {

  private Todo[] allTodos;

  public Database(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    if (queryParams.containsKey("contains")) {
      String strContained = queryParams.get("contains")[0];
      filteredTodos = filterTodosByStrContained(filteredTodos, strContained);
    }

    if (queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }

    if (queryParams.containsKey("category")) {
      String category = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, category);
    }

    if (queryParams.containsKey("status")) {
      String status = queryParams.get("status")[0];
      filteredTodos = filterTodosByStatus(filteredTodos, status);
    }

    if (queryParams.containsKey("orderBy")) {
      String factor = queryParams.get("orderBy")[0];
      filteredTodos = sortTodos(filteredTodos, factor);
    }

    if (queryParams.containsKey("limit")) {
      int limit = Integer.parseInt(queryParams.get("limit")[0]);
      filteredTodos = filterTodosByLimit(filteredTodos, limit);
    }

    return filteredTodos;
  }

  public Todo[] filterTodosByStrContained(Todo[] todos, String strContained) {
    return Arrays.stream(todos).filter(x -> x.body.contains(strContained)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
    return Arrays.stream(todos).filter(x -> x.owner.equals(targetOwner)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByStatus(Todo[] todos, String status) {
    if (status.equals("complete"))
      return Arrays.stream(todos).filter(x -> x.status).toArray(Todo[]::new);
    if (status.equals("incomplete"))
      return Arrays.stream(todos).filter(x -> !x.status).toArray(Todo[]::new);
    return Arrays.copyOf(todos, 0);
  }

  public Todo[] filterTodosByCategory(Todo[] todos, String category) {
    return Arrays.stream(todos).filter(x -> x.category.equals(category)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByLimit(Todo[] todos, int limit) {
    return Arrays.stream(todos).limit(limit).toArray(Todo[]::new);
  }

  public Todo[] sortTodos(Todo[] todos, String factor) {
    if (factor.equals("owner"))
      return Arrays.stream(todos).sorted(Comparator.comparing(x -> x.owner)).toArray(Todo[]::new);
    if (factor.equals("body"))
      return Arrays.stream(todos).sorted(Comparator.comparing(x -> x.body)).toArray(Todo[]::new);
    if (factor.equals("status"))
      return Arrays.stream(todos).sorted(Comparator.comparing(x -> x.status)).toArray(Todo[]::new);
    if (factor.equals("category"))
      return Arrays.stream(todos).sorted(Comparator.comparing(x -> x.category)).toArray(Todo[]::new);
    return todos;
  }
}
