package example.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CustomerValidate {
    @NotBlank(message = "khong duoc de trong")
    private String name;

    @NotBlank(message = "khong duoc de trong")
    private String address;

    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp="^089[0-9]{7}$",message = "So dien thoai co 10 so va bat dau bang 089")
    private String phone;

    @Email
    @NotBlank(message = "Khong duoc de trong")
    private String email;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    public CustomerValidate(String name, String address, String phone, String email, LocalDate birthday) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
    }

    public CustomerValidate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
