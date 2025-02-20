package example.springsecurity_authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("")
    public String login() {
        return "login";
    }
//    @PostMapping("/process_login")
//    public String processLogin() {
//        return "/dashboard/admin";
//    }
}
