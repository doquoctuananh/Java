package example.controller;

import example.model.Customer;
import example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerServlet {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Model model,@ModelAttribute Customer customer) {
        customerService.create(customer);
        
        return "redirect:/";
    }
}
