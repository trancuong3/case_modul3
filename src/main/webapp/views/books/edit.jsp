<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
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
    </style>
</head>
<body>
<div class="container">
    <h1>Edit Book</h1>
    <form action="books?action=update" method="post">
        <input type="hidden" name="id" value="${book.id}"/>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" value="${book.title}" required>
        </div>
        <div class="form-group">
            <label for="genre">Genre</label>
            <input type="text" class="form-control" id="genre" name="genre" value="${book.genre}" required>
        </div>
        <div class="form-group">
            <label for="authorId">Author</label>
            <select class="form-control" id="authorId" name="authorId" required>
                <c:forEach var="author" items="${authors}">
                    <option value="${author.id}" ${author.id == book.authorId ? 'selected' : ''}>${author.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update Book</button>
        <a href="/books" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
