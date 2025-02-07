package example.controller;

import example.model.Cart;
import example.model.Product;
import example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @RequestMapping("")
    public String indexCart(Model model, @SessionAttribute(name="yourCart")Cart yourCart) {
        model.addAttribute("cart", yourCart);
        return "cart";
    }

}
