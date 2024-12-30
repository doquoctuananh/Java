package example.service;

import example.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void create(Customer customer);
}
