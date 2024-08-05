package model;

public class Book {
    private int id;
    private String title;
    private String genre;
    private int authorId;

    public Book(int authorId, String genre, int id, String title) {
        this.authorId = authorId;
        this.genre = genre;
        this.id = id;
        this.title = title;
    }
    public Book(){}

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
