package example.springsecurity_authorization.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="account")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthday;

    @Column(unique= true,nullable= false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "account_role",
            joinColumns = @JoinColumn (name ="account_id",referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private List<Role> roles;

    public Account() {
    }

    public Account(Long id, String username, String password, LocalDate birthday, String email, String phone, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Account(Long id, String username, LocalDate birthday, String password, String email, String phone) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.password = password;
        this.email = email;
        this.phone = phone;
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
}
