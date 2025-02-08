package example.restful_customer.controller;

import example.restful_customer.model.Customer;
import example.restful_customer.repository.CustomerRepository;
import example.restful_customer.service.customer_service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<?> getCustomer(@RequestParam(name="page",defaultValue = "0") int page, Model model) {
//        Pageable pageable = PageRequest.of(page, 1);
        List<Customer> customers = customerService.findAll();
        if(customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer newcustomer = customerService.save(customer);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newcustomer,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<?> updateCustomer (@RequestBody Customer customer ) {
        Customer customerUpdate = customerService.save(customer);
        if(customerUpdate == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteCustomerById(@PathVariable long id) {
        Customer customer = customerService.findById(id);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
}
