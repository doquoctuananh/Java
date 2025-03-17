package example.spring_role_authorization.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;

@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotBlank(message ="Khong duoc de trong" )
    @Size(min = 3,max = 40,message = "DO dai tu 5 den 40 ki tu")

    private String name;

    @NotBlank(message = "khong duoc de trong")
    @Email
    private String email;

    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp="^0[0-9]{9}$",message = "Gom 10 so bat dau tu 0")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
