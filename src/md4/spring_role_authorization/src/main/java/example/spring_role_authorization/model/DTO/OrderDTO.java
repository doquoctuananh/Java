package example.spring_role_authorization.model.DTO;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.OrderDetail;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
    @NotBlank(message = "khong duoc de trong")
    private String name;

    @Pattern(regexp="^[0-9]{10}",message = "Gom 10 so")
    private String phone;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliveryDate;

    private String orderStatus = "pending";

    private long totalMoney;

    @NotBlank(message = "khong duoc de trong")
    private String address;

    @NotBlank(message = "khong duoc de trong")
    private String paymentMethod;

    private Account account;

//    private List<OrderDetail> orderDetails;

}
