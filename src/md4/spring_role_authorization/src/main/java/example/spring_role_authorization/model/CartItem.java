package example.spring_role_authorization.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;


    private int quantity;

    public CartItem() {
    }

    public CartItem(Long id, Account account, Product product, int quantity) {
        this.id = id;
        this.account = account;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Account account, Product product, int quantity) {
        this.account = account;
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
