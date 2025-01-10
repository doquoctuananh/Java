package example.controller;

import example.model.User;
import example.model.UserLogin;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserServlet {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model, @RequestParam(value="page",defaultValue = "0",required = false) int page) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<User> users = userService.findAll(pageable);
        model.addAttribute("users", users);
        return "user/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userLogin", new UserLogin());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLogin userLogin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
            return "user/login";
        }
        User user = userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
        if (user == null) {
            return "user/login";
        }
        return "user/index";
    }

    @PostMapping("/create")
    public String create(Model model, @Valid @ModelAttribute User user, BindingResult bindingResult) {
        System.out.println(user.toString());
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
//            model.addAttribute("user",user);
            return "index";
        }
        userService.save(user);
        return "redirect:/user/login";
    }
}
