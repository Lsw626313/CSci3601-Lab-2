function getAllTodos() {
  console.log("Getting all the todos.");

  get("/api/todos", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filter() {

  console.log("Getting filters.");

  var owner = document.getElementById('owner').value;

  var limit = document.getElementById('limit').value;

  var order = document.getElementById('orderBy').value;

  var aurl = "/api/todos?";

  if (owner !== "") {aurl += "owner=" + owner + "&"}

  if (limit !== "") {aurl += "limit=" + limit + "&"}

  if (order !== "") {aurl += "orderBy=" + order + "&"}

  console.log("Getting aurl:" + aurl);

  get(aurl, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}
