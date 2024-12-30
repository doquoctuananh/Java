package example.repository;

import example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICustomerRepository {
    List<Customer> findAll();
    void create(Customer customer);
}
