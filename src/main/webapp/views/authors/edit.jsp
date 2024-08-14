<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Author</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Edit Author</h1>
    <form action="authors?action=update" method="post">
        <input type="hidden" name="id" value="${author.id}"/>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${author.name}" required>
        </div>
        <div class="form-group">
            <label for="bio">Bio</label>
            <textarea class="form-control" id="bio" name="bio" rows="5" required>${author.bio}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Update Author</button>
        <a href="authors" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
