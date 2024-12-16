<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Sandwich Condiment</title>
</head>
<body>
<h2>Sandwich Condiment</h2>
<form action="save" method="get">
  <input type="checkbox" id="lett" name="condiment" value="Lettuce">Lettuce
  <input type="checkbox" id="toma" name="condiment" value="Tomato">Tomato
  <input type="checkbox" id="must" name="condiment" value="Mustard">Mustard
  <input type="checkbox" id="spro" name="condiment" value="Sprouts">Sprouts <br>
  <hr>
  <button type="submit" id="save"  name="action" value="save">Save</button>
</form>
<c:if test="${ not empty error}">
  <p style="color: red">${error}</p>
</c:if>
<c:if test="${not empty condiment}">
  <p>Condiment saved: </p>
<c:forEach var="condiment" items="${condiment}">
    <p>${condiment}</p>
</c:forEach>
</c:if>
</body>
</html>
