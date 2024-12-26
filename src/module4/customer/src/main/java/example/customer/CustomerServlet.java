package example.customer;

import example.model.Customer;
import example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerServlet {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String home(){
        return "index";
    }

    @GetMapping("/customer")
    public String getCustomer(Model model){
        List<Customer> customers = customerService.showAllCustomers();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/customer/create")
    public String createCustomer(){
        return "create";
    }
    @PostMapping("/customer/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer){
        customerService.createCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/update/{id}")
    public String updateCustomer(Model model, @PathVariable int id){
        Customer customer = customerService.showDetailCustomer(id);
        model.addAttribute("customer", customer);
        return "update";
    }
    @PostMapping("/customer/update/{id}")
    public String updateCustomer(Model model,@PathVariable int id,
                                 @ModelAttribute("customer") Customer customer){
        customerService.updateCUstomer(customer);
        return "redirect:/customer";
    }


    @GetMapping ("/customer/delete/{id}")
    public String deleteCustomer(Model model, @PathVariable int id){
        boolean result = customerService.deleteCustomer(id);
        return "redirect:/customer";
    }

    @GetMapping("/customer/viewdetail/{id}")
    public String viewDetailCustomer(Model model, @PathVariable int id){
        Customer customer = customerService.showDetailCustomer(id);
        model.addAttribute("customer", customer);
        return "viewdetail";
    }
}
