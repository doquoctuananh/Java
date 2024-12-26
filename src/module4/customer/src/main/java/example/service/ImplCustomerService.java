package example.service;

import example.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImplCustomerService implements ICustomerService {
    private static List<Customer> customers;
    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1,"tuan anh","nghe an","anh.dqt@gmail.com"));
        customers.add(new Customer(2,"tuan anh2","nghe an2","anh.dqt2@gmail.com"));
        customers.add(new Customer(3,"tuan anh3","nghe an3","anh.dqt3@gmail.com"));
    }
    @Override
    public List<Customer> showAllCustomers() {
        return customers;
    }

    @Override
    public void createCustomer(Customer customer) {
        customers.add(customer);

    }

    @Override
    public boolean updateCUstomer(Customer customer) {
        boolean result = false;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean result = false;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id) {
                customers.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Customer showDetailCustomer(int id) {
        Customer customer=null ;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customer = customers.get(i);
                break;
            }
        }
        return customer;
    }
}
