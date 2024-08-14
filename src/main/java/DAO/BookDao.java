package DAO;
import model.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BookDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/book_management?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "trancuong365421";
    private static final String INSERT_BOOK_SQL = "INSERT INTO books(title, genre, author_id) VALUES (?, ?, ?);";
    private static final String SELECT_BOOK_BY_ID = "SELECT id, title, genre, author_id FROM books WHERE id = ?;";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books;";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE id = ?;";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET title = ?, genre = ?, author_id = ? WHERE id = ?;";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void insertBook(Book book) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getGenre());
            preparedStatement.setInt(3, book.getAuthorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int authorId = rs.getInt("author_id");
                book = new Book();
                book.setId(id);
                book.setTitle(title);
                book.setGenre(genre);
                book.setAuthorId(authorId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int authorId = rs.getInt("author_id");
                Book book = new Book();
                book.setId(id);
                book.setTitle(title);
                book.setGenre(genre);
                book.setAuthorId(authorId);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getGenre());
            statement.setInt(3, book.getAuthorId());
            statement.setInt(4, book.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public void updateIdsAfterDelete(int deletedId) throws SQLException {
        String query = "UPDATE books SET id = id - 1 WHERE id > ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, deletedId);
            statement.executeUpdate();
        }
    }

    public List<Book> searchBooks(String query) {
        List<Book> books = new ArrayList<>();
        String sqlQuery = "SELECT b.id, b.title, b.genre, a.name AS authorName FROM books b " +
                "JOIN authors a ON b.author_id = a.id " +
                "WHERE b.title LIKE ? OR a.name LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            String searchTerm = "%" + query + "%";
            preparedStatement.setString(1, searchTerm);
            preparedStatement.setString(2, searchTerm);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String authorName = rs.getString("authorName");
                Book book = new Book();
                book.setId(id);
                book.setTitle(title);
                book.setGenre(genre);
                book.setAuthorName(authorName);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


}
