package example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLogin {
    @Email
    private String email;

    @NotBlank(message = "khong duoc de trong")
    @Size(min = 6,max = 15,message = "ki tu it nhat 6 ki tu va nhieu nhat 15 ki tu")
    private String password;

    public UserLogin() {
    }

    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
