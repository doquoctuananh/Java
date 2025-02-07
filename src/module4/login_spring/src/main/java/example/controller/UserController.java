package example.controller;

import example.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
@SessionAttributes("user")
public class UserController {
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }
    @GetMapping("/")
    public String index(@CookieValue(value = "setUser",defaultValue = "") String setUser, Model model,
                        HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user,HttpServletResponse response, HttpServletRequest request,
                        @CookieValue(value = "setUser",defaultValue = "") String setUser,Model model) {

        if(user.getEmail().equals("admin@gmail.com") &&
                user.getPassword().equals("123456")) {
            if(user.getEmail()!= null){
                setUser = user.getEmail();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24*24*60);
            response.addCookie(cookie);

            model.addAttribute("message", "login successful");
            model.addAttribute("setUser", cookie.getValue());

        }
        else{
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "login failed");
        }
        return "index";
    }

}
