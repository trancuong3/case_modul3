<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Author List</title>
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
    <h1>Author List</h1>

    <form action="authors" method="get">
        <div class="form-group">
            <input type="text" class="form-control" id="searchQuery" name="searchQuery"placeholder="Search by Name or Bio">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
        <a href="views/authors/form.jsp" class="btn btn-success">Add New Author</a>
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
                    <a href="authors/edit?id=${author.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="authors/delete?id=${author.id}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
