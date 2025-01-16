package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerServlet {
    @GetMapping("")
    public String customerPage() {
        return "index";
    }
}
