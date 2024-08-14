<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <a href="index.jsp" class="btn btn-secondary back-button">Back</a>
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
        .back-button {
            margin-bottom: 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 50px;
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            text-transform: uppercase;
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: #0056b3;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Book List</h1>
    <form action="books" method="get">
        <div class="form-group">
            <input type="text" class="form-control" id="searchQuery" name="searchQuery" placeholder="Search " value="${param.searchQuery}">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
        <a href="books?action=new" class="btn btn-success">Add New Book</a>
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
                    <a href="books?action=edit&id=${book.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="books/delete?id=${book.id}&action=delete" onclick="return confirm('Are you want delete?')" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
