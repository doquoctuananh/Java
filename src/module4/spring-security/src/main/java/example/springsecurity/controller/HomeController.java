package example.springsecurity.controller;

import example.springsecurity.model.Account;
import example.springsecurity.model.Role;
import example.springsecurity.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("")
    public String home() {
        return "/index";
    }

    @RequestMapping("/login")
    public String userLogin() {
        return "/login";
    }

    @RequestMapping("/user")
    public String user(Principal principal) {
        String username = principal.getName();
        Account account = accountService.findAccountByUsername(username);
        List<Role> roles = account.getRoles();
        for (Role role : roles) {
            if (role.getName().equals("ROLE_ADMIN")) {
                return "/admin";
            }
        }
        return "/user";
    }



}
