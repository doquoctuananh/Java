<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/21/2024
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Detail
<div>
  <label>Id</label>
  <input value="${customer.getId()}">
</div>
<div>
  <label>name</label>
  <input value="${customer.getName()}">
</div>
<div>
  <label>email</label>
  <input value="${customer.getEmail()}">
</div>
<div>
  <label>Address</label>
  <input value="${customer.getAddress()}">
</div>

<form action="/customers" method="get">
  <button type="submit" class="btn btn-primary">Back to Customer List</button>
</form>

</body>
</html>
