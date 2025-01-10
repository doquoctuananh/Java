package example.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import example.model.User;
import example.service.IUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;


@Controller
@RequestMapping("/user")
public class UserServlet {
    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public String create(Model model,@RequestParam(name ="page",defaultValue = "0",required = false) int page) {

        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("user", user);
            return "create";
        }

        userService.save(user);
        return "redirect:/";
    }
}
