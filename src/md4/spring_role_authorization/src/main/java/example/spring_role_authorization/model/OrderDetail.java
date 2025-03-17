package example.spring_role_authorization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.List;

@Entity
@Table(name = "oreder_detail")
@Check(constraints = "quantity>0")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="order_id")
    private Order order;

    @Column(nullable =false)
    private int quantity;

}
