package example.restful_customer.service.customer_service;

import example.restful_customer.model.Customer;
import example.restful_customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer save(Customer entity) {
        if(customerRepository.existsById(entity.getId())){
            return customerRepository.save(entity);
        }
        return customerRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }
}
