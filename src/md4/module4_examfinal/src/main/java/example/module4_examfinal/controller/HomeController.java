package example.module4_examfinal.controller;

import example.module4_examfinal.model.Product;
import example.module4_examfinal.model.TypeProduct;
import example.module4_examfinal.service.ProductService;
import example.module4_examfinal.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductService typeProductService;
    @GetMapping("")
    public String home(Model model,
                       @RequestParam(name = "page",defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Product> products = productService.findAllProducts(pageable);
        model.addAttribute("products", products);

        List<TypeProduct> typeProducts = typeProductService.findAllTypeProducts();
        model.addAttribute("typeProducts", typeProducts);
        return "index";
    }

    @GetMapping("/search/reset")
    public String reset(Model model) {
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "searchname",required = false) String searchname,
                         @RequestParam(name = "seachprice",required = false) Double seachprice,
                         @RequestParam(name = "searchTypeId",required = false) Long searchTypeId,
                         @RequestParam(name = "page",defaultValue = "0") int page,
                         Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Product> products = productService.searchProducts(searchname, seachprice, searchTypeId,pageable);
        model.addAttribute("products", products);

        List<TypeProduct> typeProducts = typeProductService.findAllTypeProducts();
        model.addAttribute("typeProducts", typeProducts);

        return "index";
    }
}
