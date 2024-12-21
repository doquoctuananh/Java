package com.example.service;

import com.example.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplCustomerService implements ICustomerService {
    private List<Customer> customers = new ArrayList<>();
    public ImplCustomerService() {
        customers.add(new Customer(1,"tuan anh1","nghe an","annh@gmail.com"));
        customers.add(new Customer(2,"tuan anh2","nghe an2","annh2@gmail.com"));
        customers.add(new Customer(3,"tuan anh3","nghe an3","annh3@gmail.com"));
        customers.add(new Customer(4,"tuan anh4","nghe an4","annh4@gmail.com"));
    }

    @Override
    public List<Customer> showAll() {
        return customers;
    }
}
