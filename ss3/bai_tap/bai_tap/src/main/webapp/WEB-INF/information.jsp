<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Settings</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 font-weight-bold">Settings</h2>
    <!-- Spring Form -->
    <form:form method="post" action="/update" modelAttribute="emails">
        <!-- Languages -->
        <div class="form-group row">
            <label for="language" class="col-sm-2 col-form-label">Languages:</label>
            <div class="col-sm-10">
                <form:select path="language" id="language" cssClass="form-control w-25">
                    <form:options items="${language}" />
                </form:select>
            </div>
        </div>

        <!-- Page Size -->
        <div class="form-group row">
            <label for="pageSize" class="col-sm-2 col-form-label">Page Size:</label>
            <div class="col-sm-10 d-flex align-items-center">
                <span>Show</span>
                <form:select path="size" id="pageSize" cssClass="form-control mx-2 w-25">
                    <form:options items="${size}" />
                </form:select>
                <span>emails per page</span>
            </div>
        </div>

        <!-- Spam Filter Checkbox -->
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Spams filter:</label>
            <div class="col-sm-10">
                <div class="form-check">
                    <form:checkbox path="filter" id="spamsFilter" cssClass="form-check-input" />
                    <label class="form-check-label" for="spamsFilter">
                        Enable spams filter
                    </label>
                </div>
            </div>
        </div>

        <!-- Signature -->
        <div class="form-group row">
            <label for="signature" class="col-sm-2 col-form-label">Signature:</label>
            <div class="col-sm-10">
                <form:textarea path="signature" id="signature" cssClass="form-control" rows="4" />
            </div>
        </div>

        <!-- Buttons -->
        <div class="form-group row">
            <div class="col-sm-10 offset-sm-2">
                <button type="submit" class="btn btn-primary">Update</button>
                <button type="reset" class="btn btn-light border">Cancel</button>
            </div>
        </div>
    </form:form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
