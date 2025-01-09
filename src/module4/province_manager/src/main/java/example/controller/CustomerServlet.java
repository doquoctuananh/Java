package example.controller;

import example.model.Customer;
import example.model.CustomerDTOView;
import example.model.Province;
import example.service.customer.ICustomerService;
import example.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerServlet {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("")
    public String customerPage(Model model) {
        model.addAttribute("customers",customerService.findAll());
        return "customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("provinces", provinceService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer")Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("id") int id) {
        customerService.delete(id);
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces",provinces);
        model.addAttribute("customer",customer);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer")Customer customer) {
        customerService.save(customer);
        return"redirect:/customer";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") long id, Model model) {
        CustomerDTOView customerDTOView =  customerService.viewCustomer(id);


        model.addAttribute("firstName",customerDTOView.getFirstname());
        model.addAttribute("lastName",customerDTOView.getLastname());
        model.addAttribute("provinceName",customerDTOView.getProvincename());


        return "customer/view";
    }
}
