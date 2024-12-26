package example.controller;

import example.model.Product;
import example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductServlet {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getProducts(Model model) {
        List<Product> products = productService.showALlProduct();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("create")
    public String createProduct(Model model) {
        return "create";
    }

    @PostMapping("create")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, Model model) {
        Product product =productService.findProduct(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateProductForm( Product product) {
        productService.updateProduct(product);
        return "redirect:/product";
    }

    @GetMapping("viewdeatil/{id}")
    public String viewDetails(@PathVariable int id, Model model) {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/search")
    public String searchProduct(Model model, @RequestParam String name) {
        List<Product> products = productService.searchProduct(name);
        model.addAttribute("products", products);
        return "product";
    }
}
