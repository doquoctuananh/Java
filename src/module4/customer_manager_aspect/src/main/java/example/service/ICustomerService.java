package example.service;

import example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable) ;
    void save(Customer customer);
    void delete(long id);
    Customer findById(long id);
}
