<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Author List</title>
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
    <h1>Author List</h1>

    <form action="authors" method="get">
        <div class="form-group">
            <input type="text" class="form-control" id="searchQuery" name="searchQuery" placeholder="Search " value="${param.searchQuery}">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
        <a href="authors?action=new" class="btn btn-success">Add New Author</a>
        <a href="books" class="btn btn-secondary">Back to Book List</a>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Bio</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="author" items="${listAuthor}">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.bio}</td>
                <td>
                    <a href="authors?action=edit&id=${author.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="authors/delete?id=${author.id}&action=delete"onclick="return confirm('If you delete this author, all books related to the author will be deleted')" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
