package src.DB.Models;

public class Chain {

    private int id;
    private String name;
    private String description;
    private String dateCreate;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Chain(int id, String name, String description, String dateCreate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return name;
    }
}
