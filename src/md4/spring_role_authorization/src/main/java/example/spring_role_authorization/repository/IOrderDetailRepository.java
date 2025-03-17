package example.spring_role_authorization.repository;

import example.spring_role_authorization.model.Order;
import example.spring_role_authorization.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query("select od from OrderDetail od " +
            "where od.order.orderStatus= :status")
    Page<OrderDetail> findOrderDetailByOrderStatus(@Param("status")String status, Pageable pageable);

    Page<OrderDetail> findAll(Pageable pageable);

    @Query("select od from OrderDetail od " +
            "where od.order.id =:orderId")
    List<OrderDetail> findOrderDetailByOrderId(@Param("orderId")Long orderId);
}
