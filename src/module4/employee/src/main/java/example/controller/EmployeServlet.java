package example.controller;

import example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class EmployeServlet {
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/employee/create")
    public String create(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "view";
    }
}
