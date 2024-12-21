package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("math")
public class MathController {
    @GetMapping("")
    public String math(){
        return "math";
    }

    @GetMapping("result")
    public String find(Model model,@RequestParam double usd,@RequestParam double money){
        double Totalmoney= usd*money;
        model.addAttribute("totalmoney",Totalmoney);
        return "result";
    }
}
