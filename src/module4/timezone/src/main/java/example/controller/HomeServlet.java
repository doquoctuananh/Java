package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
@RequestMapping("")
public class HomeServlet {
    @GetMapping("")
    public String Home(){
        return "index";
    }

    @GetMapping("/timezone")
    public String getTimeZone(@RequestParam (required= false,defaultValue="Asia/Ho_Chi_Minh") String city,
                              Model model){
        Date date = new Date();
        TimeZone cityRepresent = TimeZone.getDefault();
        TimeZone citySelect = TimeZone.getTimeZone(city);
        long timeCity = date.getTime() + citySelect.getRawOffset()-cityRepresent.getRawOffset();
        date.setTime(timeCity);
        model.addAttribute("timeCity", date);
        model.addAttribute("city", city);
        return "index";
    }
}
