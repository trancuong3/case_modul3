package Servlet;
import DAO.BookDao;
import DAO.AuthorDao;
import model.Book;
import model.Author;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "BookServlet", urlPatterns = {"/books/*"})
public class BookServlet extends HttpServlet {
    private BookDao bookDao;
    private AuthorDao authorDao;
    public void init() {
        bookDao = new BookDao();
        authorDao = new AuthorDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null || action.equals("/")){
            action = "";
        }
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    try {
                        insertBook(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "delete":
                    try {
                        deleteBook(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "edit":
                    try {
                        showEditForm(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "update":
                    try {
                        updateBook(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    try {
                        listBook(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String searchQuery = request.getParameter("searchQuery");
        List<Book> listBook;

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            listBook = bookDao.searchBooks(searchQuery);
        } else {
            listBook = bookDao.selectAllBooks();
        }

        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/books/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Author> authors = authorDao.selectAllAuthors();
        request.setAttribute("authors", authors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/books/form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDao.selectBook(id);
        List<Author> authors = authorDao.selectAllAuthors();
        request.setAttribute("book", existingBook);
        request.setAttribute("authors", authors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/books/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setGenre(genre);
        newBook.setAuthorId(authorId);
        bookDao.insertBook(newBook);
        response.sendRedirect("/books");
    }
    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setGenre(genre);
        book.setAuthorId(authorId);
        bookDao.updateBook(book);
        response.sendRedirect("/books");
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDao.deleteBook(id);
        bookDao.updateIdsAfterDelete(id);
        response.sendRedirect("/books");
    }

}
