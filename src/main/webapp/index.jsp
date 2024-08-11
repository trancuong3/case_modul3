<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
        .card-deck .card {
            min-width: 200px;
        }
        footer {
            margin-top: 50px;
            padding: 20px 0;
            background-color: #f8f9fa;
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Book Management</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="/authors">Manage Authors</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/books">Manage Books</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1 class="text-center">Book Management</h1>
    <div class="card-deck">
        <div class="card">
            <div class="card-body text-center">
                <h5 class="card-title">Authors</h5>
                <p class="card-text">Manage the list of authors and their details</p>
                <a href="/authors" class="btn btn-primary">Manage Authors</a>
            </div>
        </div>
        <div class="card">
            <div class="card-body text-center">
                <h5 class="card-title">Books</h5>
                <p class="card-text">Manage the list of books and their details</p>
                <a href="/books" class="btn btn-primary">Manage Books</a>
            </div>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <p class="text-muted">2024 Book Management System</p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
