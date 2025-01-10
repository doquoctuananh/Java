package example.model;


import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name  ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "khong duoc de trong")
    @Size(min = 2, max = 50, message = "ki tu tu 2 den 50 ki tu")
    private String username;

    @NotBlank(message = "khong duoc de trong")
    @Size(min = 6,max = 15,message = "mat khau tu 6 den 15 ki tu")
    private String password;

    @NotBlank(message = "khong duoc de trong")
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^[0-9]{10}",message = "so dien thoai gom co 10 so va khong co khoang trang")
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotBlank(message = "khong duoc de trong")
    private LocalDate dateOfBirth;

    public User(String username, String password, String email, String phone, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
    public User() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
