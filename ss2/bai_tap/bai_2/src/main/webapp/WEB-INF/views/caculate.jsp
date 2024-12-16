<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Caculator</title>
</head>
<body>
<h2>Caculator</h2>
<form action="caculate" method="get">
  <input type="number" id="num1" name="num1">
  <input type="number" id="num2" name="num2">
  <br>
  <button type="submit" id="add" value="add" name = "opera">Addition(+)</button>
  <button type="submit" id="sub" value="sub" name = "opera">Subtraction(-)</button>
  <button type="submit" id="multi"  value="multi" name = "opera">Multiplication(*)</button>
  <button type="submit" id="div"  value="div" name = "opera">Division(/)</button>
</form>
<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<c:if test="${not empty result}">
  <p>Result: ${result}</p>
</c:if>
</body>
</html>