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
    <c:if test="${city.length()>0}">
        <h1>${city}</h1>
        <h4>${timeCity}</h4>
    </c:if>
    <form action="/timezone" method="get">
        <label for="cars">Choose city:</label>

        <select name="city" id="cars">
            <option value="Asia/Ho_Chi_Minh">Viet nam</option>
            <option value="Asia/Tokyo">Nhat</option>
            <option value="Singapore">Singapore</option>
            <option value="Europe/London">Anh</option>
        </select>
        <button class="btn btn-primary" type="submit">Get time</button>
    </form>

</div>
</body>
</html>