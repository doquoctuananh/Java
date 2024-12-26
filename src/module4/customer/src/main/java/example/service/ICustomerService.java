package example.service;

import example.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showAllCustomers();
    void createCustomer(Customer customer);
    boolean updateCUstomer(Customer customer);
    boolean deleteCustomer(int id);
    Customer showDetailCustomer(int id);
}
