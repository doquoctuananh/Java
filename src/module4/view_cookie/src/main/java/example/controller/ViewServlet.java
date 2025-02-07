package example.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewServlet {
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/view")
    public String view(Model model, HttpServletResponse response,
                       @CookieValue(name="count",defaultValue = "0",required = false) Integer count) {
        Cookie cookie = new Cookie("count", String.valueOf(++count));
        response.addCookie(cookie);
        model.addAttribute("count", count);
        return "view";
    }
}
