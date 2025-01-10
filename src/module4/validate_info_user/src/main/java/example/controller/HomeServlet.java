package example.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import example.model.User;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import  org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeServlet {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String home(Model model, @RequestParam(name = "page",defaultValue = "0",required = false) int page) {
        Pageable pageable = PageRequest.of(page, 2);

        Page<User> users = userService.findAll( pageable);
        model.addAttribute("users", users);
        return "index";
    }
}
