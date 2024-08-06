package model;
public class Author {
    private int id;
    private String name;
    private String bio;
    public Author(String bio, int id, String name) {
        this.bio = bio;
        this.id = id;
        this.name = name;
    }
public Author(){}
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
