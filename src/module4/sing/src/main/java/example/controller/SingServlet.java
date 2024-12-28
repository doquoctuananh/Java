package example.controller;

import example.model.Sing;
import example.model.SingForm;
import example.service.ISingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@PropertySource("classpath:upload_file.properties")
public class SingServlet {
    @Autowired
    private ISingService singService;

    @Value("${uploadFile}")
    private String uploadFile;
    @GetMapping("")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("singForm", new SingForm());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("singForm")SingForm singForm, Model model) {
        MultipartFile singFile = singForm.getSing();
        String fileName = singFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(singForm.getSing().getBytes(),new File(uploadFile+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sing sing = new Sing(singForm.getName(),singForm.getAuthor(),singForm.getType(),fileName);
        model.addAttribute("sing", sing);
        return "index";
    }

}
