package example.service.customer;

import example.model.Customer;
import example.model.CustomerDTOView;
import example.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class ImplCustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer entity) {
        customerRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void update(Customer entity) {

    }

    @Override
    public CustomerDTOView viewCustomer(long id) {
        return customerRepository.viewCustomer(id);
    }
}
