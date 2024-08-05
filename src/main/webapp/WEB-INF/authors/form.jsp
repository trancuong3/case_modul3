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
    <form action="authors/insert" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" required>
        </div>
        <div class="form-group">
            <label for="bio">Bio</label>
            <textarea class="form-control" name="bio" id="bio" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
