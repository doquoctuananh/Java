package example.spring_role_authorization.service;

import example.spring_role_authorization.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    void save(Order order);
    Page<Order> findAll(Pageable pageable);
    Order finfById(Long id);
    List<Order> findByCustomerId(Long customerId);
}
