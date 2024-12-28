package example.model;

public class Sing {
    private String name;
    private String author;
    private String type;
    private String sing;

    public Sing() {
    }

    public Sing(String name, String author, String type, String sing) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.sing = sing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSing() {
        return sing;
    }

    public void setSing(String sing) {
        this.sing = sing;
    }
}
