package example.controller;

import example.model.Customer;
import example.model.CustomerValidate;
import example.service.CustomerService;
import example.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerServlet {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("customerValidate", new CustomerValidate());
        return "create";
    }

    @PostMapping("save")
    public  String save(@Valid @ModelAttribute("customerValidate") CustomerValidate customerValidate,
                        BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerValidate, customer);
        customerService.save(customer);
        return "redirect:/";
    }
}
