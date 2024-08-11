<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Book Form</h1>

    <c:choose>
    <c:when test="${book != null}">
    <form type="hidden" name="action" value="insert"  method="post">
        <input type="hidden" name="id" value="<c:out value='${book.id}'/>" />
        </c:when>
        <c:otherwise>
        <form action="books/insert" method="post">
            </c:otherwise>
            </c:choose>

            <div class="form-group">
<%--  <input type="hidden" name="action" value="insert">--%>
  <label for="title">Title</label>
  <input type="text" class="form-control" name="title" id="title" value="${book.title}" required>
</div>
<div class="form-group">
  <label for="genre">Genre</label>
  <input type="text" class="form-control" name="genre" id="genre" value="${book.genre}">
</div>
<div class="form-group">
  <label for="authorId">Author ID</label>
  <input type="number" class="form-control" name="authorid" id="authorid" value="${book.authorid}">
</div>
<button type="submit" class="btn btn-primary">Save</button>
</form>
</div>
</body>
</html>
