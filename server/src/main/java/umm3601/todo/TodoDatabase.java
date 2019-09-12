package umm3601.todo;

import com.google.gson.Gson;
import umm3601.user.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  public Todo[] listTodos(Map<String, String[]>  queryParams) {
    Todo[] filteredTodos = allTodos;

//    if (queryParams.containsKey("owner")) {
//      String targetOwner = queryParams.get("owner")[0];
//      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
//    }

    if (queryParams.containsKey("limit")) {
      int limit = Integer.parseInt(queryParams.get("limit")[0]);
      filteredTodos = Arrays.copyOf(filteredTodos, Math.min(limit, filteredTodos.length));
    }

    return filteredTodos;
  }

//  public Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
//    return Arrays.stream(todos).filter(x -> x.owner.equals(targetOwner)).toArray(Todo[]::new);
//  }

}
