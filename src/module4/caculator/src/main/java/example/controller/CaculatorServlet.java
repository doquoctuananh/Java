package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class CaculatorServlet {
    @GetMapping("")
    public String Home(){
        return "index";
    }
    @GetMapping("/caculator")
    public  String getCaculator(Model model,@RequestParam(required = false) double value1,
                                @RequestParam(required = false) double value2, @RequestParam(required = false) String caculator){
        double result =0;
        if (caculator.trim().equals("add")) {
            caculator = "+";
            result = value1 + value2;

        }
        else if (caculator.trim().equals("sub")) {
            caculator = "-";
            result = value1 - value2;
        }
        else if (caculator.trim().equals("multiplication")) {
            caculator = "*";
            result = value1 * value2;
        }
        else{
            try{
                result = value1/value2;
            }catch (ArithmeticException e){
                caculator = "/";
                e.printStackTrace();
            }
        }
        model.addAttribute("value1",value1);
        model.addAttribute("value2",value2);
        model.addAttribute("caculator",caculator);
        model.addAttribute("result",result);
        return "index";
    }

}
