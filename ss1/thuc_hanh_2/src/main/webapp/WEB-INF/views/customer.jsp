<%--
  Created by IntelliJ IDEA.
  User: 84357
  Date: 12/13/2024
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="customer" items="${customerList}" varStatus="c">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>
                <button type="button" class="btn btn-link">Detail</button>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
