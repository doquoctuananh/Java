package com.example.controller;

import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.service.ImplCustomerService;

import java.util.List;

@Controller

@RequestMapping("customers")
public class CustomerServlet {
    @Autowired
    private ImplCustomerService customerService ;
    @GetMapping("")
    public String showAll(Model model) {
        List<Customer> customers = customerService.showAll();
        model.addAttribute("customers", customers);
        return "showAll";
    }

    @GetMapping("/info/{id}")
    public String showCustomer(Model model,@PathVariable int id) {
        List<Customer> customers = customerService.showAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                model.addAttribute("customer",customers.get(i));
                break;
            }
        }
        return "info";
    }
}
