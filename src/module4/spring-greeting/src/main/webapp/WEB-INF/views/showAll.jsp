<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    .container{
      margin-top: 30px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Bordered Table</h2>
  <p>The .table-bordered class adds borders to a table:</p>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Address</th>
      <th>Email</th>
      <th>View</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customers}">
      <tr>
        <td>
          ${c.getId()}
        </td>
        <td>
          ${c.getName()}
        </td>
        <td>
          ${c.getEmail()}
        </td>
        <td>
          ${c.getAddress()}
        </td>
        <td>
            <a href="customers/info/${c.getId()}" class="btn btn-info"> view detail</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>