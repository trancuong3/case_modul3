package model;
public class Book {
    private int id;
    private String title;
    private String genre;
    private int authorId;
    private String authorName;

    public Book(int authorId, String genre, String id, int title) {
        this.authorId = authorId;
        this.genre = genre;
        this.id = Integer.parseInt(id);
        this.title = String.valueOf(title);
    }
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
