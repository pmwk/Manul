package src.DB.Models;

public class Dementor {

    private int id;
    private String hash;
    private String name;
    private String path;
    private String date;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dementor() {
    }

    public Dementor(int id, String hash, String name, String path, String date, String description) {
        this.id = id;
        this.hash = hash;
        this.name = name;
        this.path = path;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
