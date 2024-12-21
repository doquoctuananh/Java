package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("vocabulary")
public class VocabularyServlet {

    @GetMapping("")
    public String vocabulary(Model model,@RequestParam String vocabulary) {
        if(vocabulary.equals("name")){
            model.addAttribute("name","tuan anh");
        }
        return "vocabulary";
    }
}
