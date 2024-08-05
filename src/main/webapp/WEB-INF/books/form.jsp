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
    <form action="books/insert" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" name="title" id="title" required>
        </div>
        <div class="form-group">
            <label for="genre">Genre</label>
            <input type="text" class="form-control" name="genre" id="genre">
        </div>
        <div class="form-group">
            <label for="authorId">Author</label>
            <select class="form-control" name="authorId" id="authorId">
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
