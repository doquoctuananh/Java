package example.service.customer_service;

import example.model.Customer;
import example.repository.customer_repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service

public class ImplCustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer entity) {
        customerRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer findById(int id) {
       return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer entity) {
        customerRepository.update(id, entity);
    }
}
