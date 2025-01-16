package example.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BookValidate {
    @NotBlank(message = "khong duoc de trong")
    @Size(min = 3,message = "ten toi thieu 3 ki tu")
    private String name;

    @NotBlank(message = "khong duoc de trong")
    private String author;

//    @NotBlank(message = "khong duoc de trong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

//    @NotBlank(message = "khong duoc de trong")
    @Min(value = 1,message = "phai nhap so luong toi thieu la 1")
    private int quantity;

    public BookValidate() {
    }

    public BookValidate(String name, String author, LocalDate publishDate, int quantity) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.quantity = quantity;
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

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
