package example.spring_role_authorization.model.DTO;

import example.spring_role_authorization.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class ProductDTO {
    @NotBlank(message = "khong duoc de trong")
    @Size(min=5,max=20,message = "do dai tu 5 den 20 ki tu")
    private String name;

    @NotBlank(message = "khong duoc de trong")
    private String color;

    @NotNull(message = "khong duoc de trong")
    @Min(1)
    private double price;

    @NotNull(message = "khong duoc de trong")
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate guarantee;

    @NotBlank(message = "khong duoc de trong")
//    @Min(8)
    private String capacity;

    @NotBlank(message = "khong duoc de trong")
    private String image;

//    @NotBlank(message = "khong duoc de trong")
    private Category category;
    @Min(value = 1,message = "so luong hon 1 san pham")
    private int stock;

    public ProductDTO() {
    }

    public ProductDTO(String name, String color, double price,
                      LocalDate guarantee, String capacity, String image,Category category,int stock) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.guarantee = guarantee;
        this.capacity = capacity;
        this.image = image;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getGuarantee() {
        return guarantee;
    }
    public void setGuarantee(LocalDate guarantee) {
        this.guarantee = guarantee;
    }
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

}
