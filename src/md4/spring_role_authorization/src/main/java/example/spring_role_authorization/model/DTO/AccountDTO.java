package example.spring_role_authorization.model.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
    @NotBlank(message = "khong duoc de trong")
    @Size(min=5,max=30,message = "phai tu 5 den 30 ki tu")
    private String username;

    @NotBlank(message = "khong duoc de trong")
    private String password;

    @NotNull(message = "khong duoc de trong")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message = "khong duoc de trong")
    private String address;

    @NotBlank(message = "khong duoc de trong")
    @Email
    private String email;

    @NotBlank(message = "khong duoc de trong")
    private String phone;

    @NotNull(message = "khong duoc de trong")
    private boolean gender;

//    @NotBlank(message = "khong duoc de trong")
    private String roles;


}
