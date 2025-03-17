package example.spring_role_authorization.controller;

import example.spring_role_authorization.common.CustomBcryptPasswordUtils;
import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.DTO.AccountDTO;
import example.spring_role_authorization.model.Product;
import example.spring_role_authorization.model.Roles;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.repository.IRoleRepository;
import example.spring_role_authorization.service.Impl.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.security.Principal;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IRoleRepository roleRepository;

    @GetMapping("/login")
    public String login(@RequestParam(name = "error",defaultValue = "",required= false) String error,
                        Model model) {
        if (!error.isEmpty()) {
            model.addAttribute("error","Tai khoan nhap bi sai");
        }
        return "login";
    }

    @GetMapping("")
    public String home(Model model,
                       @RequestParam(name="page",defaultValue="0") int page) {

        Pageable pageable = PageRequest.of(0,10);
        Page<Product> productList = productService.findAll(pageable);
        model.addAttribute("productList",productList);
        return "/index";
    }




}
