<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="post" action="/update" modelAttribute="emails">
    Language:
    <form:select path="language" id="language">
        <form:options items="${language}" />
    </form:select>
    <br>
    Page size:
    Show
    <form:select path="size" id="size">
        <form:options items="${size}" />
    </form:select> email per page
    <br>
    Spams filter:
    <form:checkbox path="filter" /> Enable spams filter
    <br>
    Signature:
    <form:textarea path="signature"></form:textarea>
    <br>
    <button type="submit">Update</button>
    <a href="/update" style="text-decoration: none;">
        <button type="button">Cancel</button>
    </a>
</form:form>
<c:if test="${update}">
    <h3>Update Successfully</h3>
    <h4>Updated Information:</h4>
    <div>
        <p>Language:${emails.language}</p>
        <p>Page Size:${emails.size}</p>
        <p>Spam Filter:${emails.filter ? 'Enabled' : 'Disabled'}</p>
        <p>Signature: ${emails.signature}</p>
    </div>
</c:if>
</body>
</html>
