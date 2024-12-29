package example.controller;

import example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailServlet {
    @GetMapping("")
    public String homePage(){
        return "index";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("email", new Email());
        return "create";
    }

    @PostMapping("/update")
    public String updatePage(Model model,@ModelAttribute Email email){
        model.addAttribute("email", email);
        return "index";
    }
}
