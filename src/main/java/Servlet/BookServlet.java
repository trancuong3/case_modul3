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

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookDao bookDao;
    private AuthorDao authorDao;

    public void init() {
        bookDao = new BookDao();
        authorDao = new AuthorDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBook(request, response);
                    break;
                case "/delete":
                    deleteBook(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listBook = bookDao.selectAllBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/books/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Author> authors = authorDao.selectAllAuthors();
        request.setAttribute("authors", authors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/books/form.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDao.selectBook(id);
        List<Author> authors = authorDao.selectAllAuthors();
        RequestDispatcher dispatcher = request.getRequestDispatcher("books/form.jsp");
        request.setAttribute("book", existingBook);
        request.setAttribute("authors", authors);
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
        response.sendRedirect("list");
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
        response.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDao.deleteBook(id);
        response.sendRedirect("list");
    }
}
