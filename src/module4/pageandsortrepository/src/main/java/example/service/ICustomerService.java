package example.service;

import example.model.Customer;
import example.repository.ICustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService  {
    Page<Customer> findAllCustomers(Pageable pageable);
    Customer findCustomerById(long id);
    void saveCustomer(Customer customer);
    void editCustomer(Customer customer);
    void deleteCustomer(long id);
}
