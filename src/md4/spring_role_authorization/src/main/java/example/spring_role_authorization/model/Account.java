package example.spring_role_authorization.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable=false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable=false)
    private boolean gender;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Roles roles;

    @OneToMany(mappedBy="account")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy= "account")
    private List<Order> orderList;

    public Account() {
    }

    public Account(Long id, String username,
                   String password, LocalDate birthday,
                   String address, String email,
                   String phone, boolean gender, Roles roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.roles = roles;
    }

    public Account(Long id, String username, String password, LocalDate birthday,
                   String address, String email, String phone, boolean gender, Roles roles,
                   List<CartItem> cartItems,List<Order> orderList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.roles = roles;
        this.cartItems = cartItems;
        this.orderList = orderList;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
