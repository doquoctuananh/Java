package example.spring_role_authorization.controller.dashboard;

import example.spring_role_authorization.model.Category;
import example.spring_role_authorization.model.DTO.CategoryDTO;
import example.spring_role_authorization.service.Impl.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dashboard/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String category(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "dashboard/category/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryDTO", new CategoryDTO());
        return "/dashboard/category/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
                         BindingResult bindingResult, Model model) {
        System.out.println(categoryDTO.getEmail());
        Category category = new Category();
        if(bindingResult.hasErrors()) {
            model.addAttribute("category", categoryDTO);
            return "/dashboard/category/create";
        }
        else{
            BeanUtils.copyProperties(categoryDTO, category);

            model.addAttribute("message", "Create category successful");
            System.out.println(category.getEmail());
            categoryService.createCategory(category);
            List<Category> categoryList = categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            return "/dashboard/category/home";
        }

    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id")int id) {
        Category category = categoryService.findCategoryById(id);
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category, categoryDTO);
        model.addAttribute("categoryDTO", categoryDTO);
        model.addAttribute("id", id);
        return "/dashboard/category/edit";
    }

    @PostMapping("/edit")
    public String edit(Model model,@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO
    , BindingResult bindingResult,@RequestParam("id") long id) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("categoryDTO", categoryDTO);
            model.addAttribute("id", id);
            return "/dashboard/category/edit";
        }
        else{
            Category category = new Category();
            BeanUtils.copyProperties(categoryDTO, category);
            category.setId(id);
            categoryService.createCategory(category);
            List<Category> categoryList = categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("message", true);
            return "redirect:/dashboard/category";
        }
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam(name = "id")long id) {
        categoryService.deleteCategory(id);
        return "redirect:/dashboard/category";
    }
}
