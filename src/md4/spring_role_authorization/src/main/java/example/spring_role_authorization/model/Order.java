package example.spring_role_authorization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private String orderStatus = "pending";

    private long totalMoney;

    private String address;

    private String paymentMethod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

}
