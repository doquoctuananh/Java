package example.controller;

import example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeServlet {
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
