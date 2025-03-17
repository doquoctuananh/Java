package example.spring_role_authorization.service.Impl;

import example.spring_role_authorization.model.Order;
import example.spring_role_authorization.repository.IOrderRepository;
import example.spring_role_authorization.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order finfById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}
