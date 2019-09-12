function getAllTodos() {
  console.log("Getting all the todos");

  get("/api/todos", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function go() {
  var api = document.getElementById('api').value;

  console.log("Getting:" + api);

  get(api, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filter() {
  console.log("Getting filters");

  var str =  document.getElementById('str').value;

  var category = document.getElementById('category').value;

  var owner = document.getElementById('owner').value;

  var status = document.getElementById('status').value;

  var limit = document.getElementById('limit').value;

  var order = document.getElementById('orderBy').value;

  var aurl = "api/todos";

  if (str !== "" || category !== "" || owner !== "" || status !== "" || limit !== "" || order !== "") {
    aurl += "?";

    if (str !== "") {
      aurl += "contains=" + str + "&"
    }

    if (category !== "") {
      aurl += "category=" + category + "&"
    }

    if (owner !== "") {
      aurl += "owner=" + owner + "&"
    }

    if (status !== "") {
      aurl += "status=" + status + "&"
    }

    if (limit !== "") {
      aurl += "limit=" + limit + "&"
    }

    if (order !== "") {
      aurl += "orderBy=" + order + "&"
    }

    aurl = aurl.substring(0, aurl.length - 1);
  }

  console.log("Getting aurl:" + aurl);

  get(aurl, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}
