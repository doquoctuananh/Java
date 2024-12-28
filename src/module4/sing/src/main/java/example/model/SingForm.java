package example.model;

import org.springframework.web.multipart.MultipartFile;

public class SingForm {
    private String name;
    private String author;
    private String type;
    private MultipartFile sing;

    public String getName() {
        return name;
    }

    public SingForm(String name, String author, String type, MultipartFile sing) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.sing = sing;
    }

    public SingForm() {
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

    public MultipartFile getSing() {
        return sing;
    }

    public void setSing(MultipartFile sing) {
        this.sing = sing;
    }
}
