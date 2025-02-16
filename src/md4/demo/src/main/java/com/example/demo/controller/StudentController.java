package com.example.demo.controller;

import com.example.demo.model.Clazz;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.IClazzService;
import com.example.demo.service.IStudentService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller // annotation: đánh dấu 1 class là controller giúp IOC Container tạo ra bean
@RequestMapping("/") // url handle mapping: cơ chế ánh xạ request đến controller tương ứng
@SessionAttributes("clazzes")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClazzService iClazzService;

    @ModelAttribute("clazzes")
    public void setClazzes(Model model){
        model.addAttribute("clazzes", iClazzService.findAll());
    }
    /*
     * @RequestParam: default value, required
     * @PathVariable
     * Tại sao lại dùng @RequestParam mà không @PathVariable*/
    @GetMapping()
    public ModelAndView showHomePage(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                     Model model) {

        ModelAndView mav = new ModelAndView("home");
        //pageNumber <=> current page -> bắt đầu từ trang 0
        //pageSize => số lượng record mỗi trang
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(page, 2, sort);
        mav.addObject("students", iStudentService.findAll(pageable));
        return mav;
    }

    @GetMapping("create-form") // handle method
    public String showCreateForm(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
//        model.addAttribute("clazzes", iClazzService.findAll());
        return "create-form";
    }

    @PostMapping("add-student")
    public String submitForm(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create-form";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Them moi thanh cong");
        return "redirect:/";
    }

    @GetMapping("set-cookie")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "C06");
        response.addCookie(cookie);
        return "redirect:/show-cookie";
    }

    @GetMapping("show-cookie")
    public String showCookie(@CookieValue(name = "name",defaultValue = "blank", required = false) String name,
                             Model model) {
        model.addAttribute("cookie", name);
        return "show-cookie";
    }
}
