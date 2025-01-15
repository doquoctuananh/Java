package example.controller;

import example.service.CustomerService;
import example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class HomeServlet {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String HomeServlet(Model model,
                              @RequestParam(value = "page",defaultValue = "0",required = false) int page) {
        Pageable pageable = PageRequest.of(page,1);
        model.addAttribute("customers",customerService.findAll(pageable));
        return "index";
    }
}
