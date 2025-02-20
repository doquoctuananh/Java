package example.module4_examfinal.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    @NotBlank(message = "khong duoc de trong")
    @Size(min = 5,max=50,message = "ten tu 5 den 50 ki tu")
    private String nameProduct;

    @NotNull(message = "khong duoc de trong")
    @Min(value = 100000,message = "gia tu 100.000VND")
    private double price;


    private long typeProduct;

    public ProductDTO() {
    }

    public ProductDTO(String nameProduct, double price, long typeProduct) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.typeProduct = typeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public long getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(long typeProduct) {
        this.typeProduct = typeProduct;
    }
}
