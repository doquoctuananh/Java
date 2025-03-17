package example.spring_role_authorization.controller.dashboard;

import example.spring_role_authorization.model.DTO.ProductDTO;
import example.spring_role_authorization.model.Product;
import example.spring_role_authorization.service.Impl.CategoryService;
import example.spring_role_authorization.service.Impl.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dashboard/product")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Product> productList = productService.findAll(pageable);
        model.addAttribute("productList", productList);
        return "dashboard/product/home";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("Category",categoryService.findAll());
        return "/dashboard/product/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                         BindingResult bindingResult, Model model,
                         @RequestParam(name = "page",defaultValue="0") int page) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("Category",categoryService.findAll());
            model.addAttribute("productDTO",productDTO);
            return "/dashboard/product/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
//        Pageable pageable = PageRequest.of(page, 10);
//        Page<Product> productList = productService.findAll(pageable);
//        model.addAttribute("productList",productList);
        return "redirect:/dashboard/product";
    }

    @GetMapping("/edit")
    public String editProduct(Model model,@RequestParam(name= "id") int id) {
        ProductDTO productDTO  = new ProductDTO();
        Product product = productService.findById(id);
        BeanUtils.copyProperties(product, productDTO);
        model.addAttribute("id",id);
        model.addAttribute("productDTO",productDTO);
        model.addAttribute("Category",categoryService.findAll());

        return "/dashboard/product/edit";
    }

    @PostMapping("/edit")
    public String edit(Model model,
                       @Valid @ModelAttribute(name = "productDTO") ProductDTO productDTO,
                       BindingResult bindingResult,
                       @RequestParam(name = "id") Long id,
                       @RequestParam(name="page",defaultValue = "0") int page) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("Category",categoryService.findAll());
            model.addAttribute("productDTO",productDTO);
            model.addAttribute("id",id);
            return "/dashboard/product/edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setId(id);
        productService.save(product);
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> productList = productService.findAll(pageable);
        model.addAttribute("productList",productList);
        return "redirect:/dashboard/product";
    }

    @GetMapping("/delete")
    public String delete(Model model
//            @RequestParam(name = "page",defaultValue = "0",required = false) int page
            ,@RequestParam(name = "id") int id) {
        productService.deleteById(id);
//        Pageable pageable = PageRequest.of(0, 10);
//        model.addAttribute("productList",productService.findAll(pageable));
        return "redirect:/dashboard/product";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "nameProduct",required = false) String nameProduct,
            @RequestParam(name ="colorProduct", required = false) String colorProduct,
            @RequestParam(name = "priceProduct",required = false) double priceProduct,
            @RequestParam(name="page",defaultValue = "0") int page
            ,Model model) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Product> productList = productService.searchProductByNameAndColorAndPrice(pageable,nameProduct,colorProduct,priceProduct);
        model.addAttribute("productList",productList);
        return "/dashboard/product/home";
    }
}

