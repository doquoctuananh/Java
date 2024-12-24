package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
@RequestMapping("")
public class CondimentServlet {
    @GetMapping("")
    public String home(){
        return "index";
    }

    @GetMapping("/condiment")
    public String condiment(Model model, @RequestParam(required = false) String[] condiment){

        model.addAttribute("condiment", condiment);
        return "index";
    }
}
