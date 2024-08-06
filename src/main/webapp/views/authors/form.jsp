<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Author Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Author Form</h1>

    <c:if test="${author != null}">
    <form action="authors/update" method="post"> <%-- Update existing author --%>
        <input type="hidden" name="id" value="<c:out value='${author.id}'/>"/>
        </c:if>
        <c:if test="${author == null}">
        <form action="authors/insert" method="post"> <%-- Insert new author --%>
            </c:if>

            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" name="name" id="name" value="${author.name}" required>
            </div>
            <div class="form-group">
                <label for="bio">Bio</label>
                <textarea class="form-control" name="bio" id="bio" rows="3">${author.bio}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
</div>
</body>
</html>
