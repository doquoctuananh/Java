<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/21/2024
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form action="vocabulary">
        <label>Enter Vocabulary</label>
        <input type="text" placeholder="Enter vocabulary" name="vocabulary">
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <c:if test="${name.length() >0}">
        ${name}
    </c:if>
</div>
</body>
</html>
