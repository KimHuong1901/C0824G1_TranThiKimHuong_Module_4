<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 84357
  Date: 12/13/2024
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dictionary</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h3> Dictionary English </h3>
  <form action="/dictionary">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Enter words here..." name="word">
      <div class="input-group-btn">
        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
      </div>
    </div>
  </form>
  <div style="margin-top: 20px;">
    <c:if test="${not empty word}">
      <p>Word is : <b>${word}</b></p>
      <p>Meaning is: <b>${meaning}</b></p>
    </c:if>
  </div>
</div>
</body>
</html>

