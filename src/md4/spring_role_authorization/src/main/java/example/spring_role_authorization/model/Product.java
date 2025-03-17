package example.spring_role_authorization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)

    private String name;

    @Column(nullable= false)

    private String color;

    @Column(nullable=false)

    private double price;

    @Column(nullable=false)

    private LocalDate guarantee;

    @Column(nullable=false)
    private String capacity;

    @Column(nullable=false)
    private String image;

    @Column(nullable=false)
    private int stock;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy="product")
    private List<CartItem> CartItems;

    @OneToMany(mappedBy="product")
    private List<OrderDetail> OrdersDetails;

    public Product(Long id, String name, String color, double price,
                   LocalDate guarantee, String capacity, String image, Category category,int stock,
                   List<CartItem> CartItems,List<OrderDetail> OrdersDetails) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.guarantee = guarantee;
        this.capacity = capacity;
        this.image = image;
        this.category = category;
        this.stock = stock;
        this.CartItems = CartItems;
        this.OrdersDetails = OrdersDetails;
    }

    public List<OrderDetail> getOrdersDetails() {
        return OrdersDetails;
    }

    public void setOrdersDetails(List<OrderDetail> ordersDetails) {
        OrdersDetails = ordersDetails;
    }

    public List<CartItem> getCartItems() {
        return CartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        CartItems = cartItems;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
