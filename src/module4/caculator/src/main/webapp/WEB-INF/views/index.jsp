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
</head>
<body>
<div class="container">
    <form action="/caculator" method="get">
        <div class="form-group">
            <label for="value1">value1:</label>
            <input type="number" class="form-control" id="value1" name="value1" required>
        </div>
        <div class="form-group">
            <label for="value2">Value2:</label>
            <input type="number" class="form-control" id="value2" name="value2" required>
        </div>
        <button type="submit" class="btn btn-info" name="caculator" value="add">Add</button>
        <button type="submit" class="btn btn-info" name="caculator" value="sub">Subtraction</button>
        <button type="submit" class="btn btn-info" name="caculator" value="multiplication">Multiplication</button>
        <button type="submit" class="btn btn-info" name="caculator" value="division">Division</button>
    </form>
    <c:if test="${not empty result}">
        <h1>Result: ${value1} ${caculator} ${value2} = ${result}</h1>
    </c:if>
</div>
</body>
</html>