package DAO;
import model.Author;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AuthorDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/book_management?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "trancuong365421";
    private static final String INSERT_AUTHOR_SQL = "INSERT INTO authors (name, bio) VALUES (?, ?);";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT id, name, bio FROM authors WHERE id = ?;";
    private static final String SELECT_ALL_AUTHORS = "SELECT * FROM authors;";
    private static final String DELETE_AUTHOR_SQL = "DELETE FROM authors WHERE id = ?;";
    private static final String UPDATE_AUTHOR_SQL = "UPDATE authors SET name = ?, bio = ? WHERE id = ?;";
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
    public void insertAuthor(Author author) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR_SQL)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getBio());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Author selectAuthor(int id) {
        Author author = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String bio = rs.getString("bio");
                author = new Author();
                author.setId(id);
                author.setName(name);
                author.setBio(bio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }
    public List<Author> selectAllAuthors() {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String bio = rs.getString("bio");
                Author author = new Author();
                author.setId(id);
                author.setName(name);
                author.setBio(bio);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
    public boolean deleteAuthor(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_AUTHOR_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updateAuthor(Author author) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL)) {
            statement.setString(1, author.getName());
            statement.setString(2, author.getBio());
            statement.setInt(3, author.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public List<Author> searchAuthors(String query) {
        List<Author> authors = new ArrayList<>();
        String sqlQuery = "SELECT * FROM authors WHERE name LIKE ? OR bio LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            String searchTerm = "%" + query + "%";
            preparedStatement.setString(1, searchTerm);
            preparedStatement.setString(2, searchTerm);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String bio = rs.getString("bio");
                Author author = new Author();
                author.setId(id);
                author.setName(name);
                author.setBio(bio);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
    public List<Book> selectBooksByAuthorId(int authorId) {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books WHERE author_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, authorId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Book book = new Book(id, title, description, authorId);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


}
