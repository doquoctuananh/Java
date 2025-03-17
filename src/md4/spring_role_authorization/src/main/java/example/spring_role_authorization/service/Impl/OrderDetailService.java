package example.spring_role_authorization.service.Impl;

import example.spring_role_authorization.model.OrderDetail;
import example.spring_role_authorization.repository.IOrderDetailRepository;
import example.spring_role_authorization.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public Page<OrderDetail> findAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public Page<OrderDetail> findOrderDetailByOrderStatus(String status, Pageable pageable) {
        return orderDetailRepository.findOrderDetailByOrderStatus(status, pageable);
    }

    @Override
    public List<OrderDetail> findOrderDetailByOrderId(long orderId) {
        return orderDetailRepository.findOrderDetailByOrderId(orderId);
    }


}
