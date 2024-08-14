<h2>Are you sure you want to delete this author?</h2>
<p>The following books will also be deleted:</p>
<ul>
    <c:forEach var="book" items="${associatedBooks}">
        <li>${book.title}</li>
    </c:forEach>
</ul>

<form action="deleteConfirmed" method="post">
    <input type="hidden" name="id" value="${authorId}" />
    <button type="submit">Yes, delete</button>
    <a href="/authors">No, go back</a>
</form>
