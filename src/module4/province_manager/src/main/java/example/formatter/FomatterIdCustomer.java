package example.formatter;

import example.model.Customer;
import example.service.customer.ICustomerService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;


public class FomatterIdCustomer implements Formatter<Customer> {

    private ICustomerService customerService;

    public FomatterIdCustomer(ICustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public Customer parse(String id, Locale locale) throws ParseException {
        return customerService.findById(Long.parseLong(id));
    }

    @Override
    public String print(Customer object, Locale locale) {
        return "";
    }
}
