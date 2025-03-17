package example.spring_role_authorization.controller.user;

import example.spring_role_authorization.model.Product;
import example.spring_role_authorization.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("product")
public class UserProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/detail")
    public String detail(Model model, Principal principal,
                         @RequestParam(name ="id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "user/product/detail";
    }
}
