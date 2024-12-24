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
    <h1>Condiment</h1>
    <form action="/condiment">

        <input type="checkbox" id="condiment1" name="condiment" value="lettuce">
        <label for="condiment1"> Lettuce</label><br>

        <input type="checkbox" id="condiment2" name="condiment" value="tomato">
        <label for="condiment2"> Tomato</label><br>

        <input type="checkbox" id="condiment3" name="condiment" value="mustard">
        <label for="condiment3"> Mustard</label><br>
        <button class="btn btn-primary" type="submit">submit</button>
    </form>
    <c:if test="${not empty condiment}">

            <table style="margin-top: 15px" class="table table-bordered">
                <thead>
                <tr>
                    <th>Condiment</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${condiment}" var="condiment">
                    <tr>
                        <td>${condiment}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

    </c:if>
    <c:if test="${empty condiment}">
        <h1>Condiment not select</h1>
    </c:if>
</div>
</body>
</html>