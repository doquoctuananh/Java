package example.spring_role_authorization.service;

import example.spring_role_authorization.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderDetailService {
    Page<OrderDetail> findAll(Pageable pageable);
    Page<OrderDetail> findOrderDetailByOrderStatus(String status, Pageable pageable);
    List<OrderDetail> findOrderDetailByOrderId(long orderId);
}
