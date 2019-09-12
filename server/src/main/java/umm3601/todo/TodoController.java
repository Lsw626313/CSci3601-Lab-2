package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static umm3601.Util.*;

public class TodoController {

  private final Gson gson2;
  private TodoDatabase database;

  public TodoController(TodoDatabase database) {
    gson2 = new Gson();
    this.database = database;
  }

  public JsonObject getTodo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    Todo todo = database.getTodo(id);
    if (todo != null) {
      return buildSuccessJsonResponse("todo", gson2.toJsonTree(todo));
    } else {
      String message = "Todo with ID " + id + " wasn't found.";
      return buildFailJsonResponse("id", message);
    }
  }

  public JsonObject getTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] users = database.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("users", gson2.toJsonTree(users));
  }

}
