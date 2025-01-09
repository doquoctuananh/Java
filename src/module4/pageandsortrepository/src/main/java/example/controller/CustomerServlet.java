package example.controller;

import example.model.Customer;
import example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer")
public class CustomerServlet {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String customer(Model model, @RequestParam(value = "page",defaultValue = "0",required = false) int page) {
        Pageable pageable =  PageRequest.of(page,2,Sort.by(Sort.Direction.DESC,"name"));

        Page<Customer> customers = customerService.findAllCustomers(pageable);
        model.addAttribute("customers", customers);
        return "/customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }
}
