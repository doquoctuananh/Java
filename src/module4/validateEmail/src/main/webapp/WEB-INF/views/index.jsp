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
    <c:if test="${error.length()>0}">
        ${error}
    </c:if>
    <form action="/email">
        <div class="form-group">
            <label for="emailValidate">Email address:</label>
            <input type="text" class="form-control" id="emailValidate" name="emailValidate">
        </div>
        <button type="submit" class="btn btn-default">Validate</button>
    </form>
</div>
</body>
</html>