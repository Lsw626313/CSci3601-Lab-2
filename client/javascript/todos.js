function getAllTodos() {
  console.log("Getting all the todos.");

  get("/api/todos", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosLimitedNumber() {
  console.log("Getting todos with a maximum number.");

  get("/api/todos?limit=" + document.getElementById("limit").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByOwner() {
  console.log("Getting todos with a owner.");

  get("/api/todos?owner=" + document.getElementById("owner").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}
