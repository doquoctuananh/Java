package example.validateEmail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/email")
public class EmailServlet {
    private String regexEmail = "^[0-9A-Za-z]+@[0-9A-Za-z]+\\.[A-Za-z]+$";
    private Pattern pattern = Pattern.compile(regexEmail);
    public boolean validate(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @GetMapping("")
    public String validateEmail(@RequestParam String emailValidate, Model model) {

        if(validate(emailValidate)) {
            model.addAttribute("email", emailValidate);
            return "email";
        }
        else{
            model.addAttribute("error","Validate email fail");
            return "index";
        }

    }
}
