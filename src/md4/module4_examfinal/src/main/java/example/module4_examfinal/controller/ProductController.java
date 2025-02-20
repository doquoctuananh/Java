package example.module4_examfinal.controller;

import example.module4_examfinal.model.Product;
import example.module4_examfinal.model.ProductDTO;
import example.module4_examfinal.model.TypeProduct;
import example.module4_examfinal.repository.IProductRepository;
import example.module4_examfinal.repository.ITypeProductRepository;
import example.module4_examfinal.service.ProductService;
import example.module4_examfinal.service.TypeProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private TypeProductService typeProductService;

    @Autowired
    private ITypeProductRepository typeProductRepository;

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new ProductDTO());
        List<TypeProduct> typeProducts= typeProductService.findAllTypeProducts();
        model.addAttribute("typeProducts", typeProducts);
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult,
                         Model model) {
        Product product = new Product();
        if(bindingResult.hasErrors()) {
            model.addAttribute("product", productDTO);
            List<TypeProduct> typeProducts = typeProductService.findAllTypeProducts();
            model.addAttribute("typeProducts", typeProducts);
            return "create";
        }
        product.setNameProduct(productDTO.getNameProduct());
        product.setPrice(productDTO.getPrice());

        Optional<TypeProduct> optionalTypeProduct = typeProductRepository.findById(productDTO.getTypeProduct());
        if (optionalTypeProduct.isPresent()) {
            product.setTypeProduct(optionalTypeProduct.get());
        } else {
            throw new RuntimeException("TypeProduct không tồn tại! ID: " + productDTO.getTypeProduct());
        }


        productService.saveProduct(product);
        return"redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id,Model model) {
        productRepository.deleteById(id);
        return "redirect:/";
    }
}
