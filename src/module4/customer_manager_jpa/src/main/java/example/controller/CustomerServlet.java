package example.controller;

import example.model.Customer;
import example.model.CustomerForm;
import example.service.customer_service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
public class CustomerServlet {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String homePage(Model model) {
        List<Customer> customers =customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "create";
    }

    @Value("${uploadFile}")
    private String uploadFile;

    @PostMapping("/save")
    public String saveCustomer(Model model, @ModelAttribute CustomerForm customerForm) {
        System.out.println(customerForm.getBirthday());
        MultipartFile multipartFile = customerForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(multipartFile.getBytes(),new File(uploadFile+fileName));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Customer customer = new Customer(customerForm.getName(),customerForm.getBirthday(),fileName);
        System.out.println(customer.toString());
        customerService.save(customer);
        return "redirect:/";
    }
}
