package example.controller;

import example.model.Account;
import example.model.User;
import example.service.userservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginServlet {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "index";
    }

    @PostMapping("/login/account")
    public String loginAccount(Model model,@ModelAttribute("account") Account account) {
        User user = userService.loginUser(account);
        model.addAttribute("user", user);
        return "view";
    }
}
