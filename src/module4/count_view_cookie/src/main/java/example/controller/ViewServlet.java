package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class ViewServlet {
    @GetMapping("")
    public String index(Model model,@CookieValue(value = "countView" , defaultValue = "0",required = false) Integer countView,
                        HttpServletResponse response) {

        Cookie cookie = new Cookie("countView" , String.valueOf(countView));
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "index";
    }

    @GetMapping("/view")
    public String view(@CookieValue(value = "countView" , defaultValue = "0",required = false) Integer countView,
                       HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("countView" , String.valueOf(++countView));
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        ++countView;
        model.addAttribute("countView" , String.valueOf(countView));

        return "view";
    }
}
