package Servlet;

import DAO.AuthorDao;
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

@WebServlet(name = "AuthorServlet", urlPatterns = {"/authors/*"})
public class AuthorServlet extends HttpServlet {
    private AuthorDao authorDao;

    public void init() {
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
                    insertAuthor(request, response);
                    break;
                case "/delete":
                    deleteAuthor(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateAuthor(request, response);
                    break;
                default:
                    listAuthor(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAuthor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Author> listAuthor = authorDao.selectAllAuthors();
        request.setAttribute("listAuthor", listAuthor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/authors/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/authors/form.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Author existingAuthor = authorDao.selectAuthor(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("authors/form.jsp");
        request.setAttribute("author", existingAuthor);
        dispatcher.forward(request, response);
    }

    private void insertAuthor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String bio = request.getParameter("bio");
        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setBio(bio);
        authorDao.insertAuthor(newAuthor);
        response.sendRedirect("list");
    }

    private void updateAuthor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String bio = request.getParameter("bio");

        Author author = new Author();
        author.setId(id);
        author.setName(name);
        author.setBio(bio);

        authorDao.updateAuthor(author);
        response.sendRedirect("list");
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        authorDao.deleteAuthor(id);
        response.sendRedirect("list");
    }
}
