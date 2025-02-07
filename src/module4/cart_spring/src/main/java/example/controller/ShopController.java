package example.controller;

import example.model.Cart;
import example.model.Product;
import example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
@SessionAttributes("yourCart")

public class ShopController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("yourCart")
    public Cart setupCart(){
        return new Cart();
    }

    @RequestMapping("")
    public String index(@RequestParam(value = "page",defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Product> products = productService.getProducts(pageable);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/cart/addCart/{id}")
    public String addCart(@PathVariable("id") int id, Model model,
                          @ModelAttribute(value = "yourCart") Cart yourCart) {
        Product product = productService.findProductById(id);
        yourCart.addCart(product);
        return "redirect:/";
    }

}
