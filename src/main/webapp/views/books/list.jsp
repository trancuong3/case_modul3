<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 30px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .btn {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Book List</h1>
    <form action="books" method="get">
        <div class="form-group">
            <input type="text" class="form-control" id="searchQuery" name="searchQuery" placeholder="Search by title or genre">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
        <a href="views/books/form.jsp" class="btn btn-success">Add New Book</a>
        <a href="authors" class="btn btn-secondary">View Author List</a>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Author ID</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><c:out value="${book.title}" /></td>
                <td><c:out value="${book.genre}" /></td>
                <td><c:out value="${book.authorId}" /></td>
                <td>
                    <a href="books/edit?id=<c:out value='${book.id}' />" class="btn btn-warning btn-sm">Edit</a>
                    <a href="books/delete?id=<c:out value='${book.id}' />" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
