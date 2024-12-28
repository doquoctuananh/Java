package example.controller;

import example.model.Product;
import example.model.ProductForm;
import example.service.IProductService;
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
public class UploadFileController {
    @Autowired
    private IProductService productService;

    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/product/create")
    public String createProduct(Model model) {
        model.addAttribute("productForm",new ProductForm());
        return "create";
    }

    @PostMapping("/product/create/createForm")
    public String createProductForm(Model model, @ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(productForm.getImage().getBytes(),new File(fileUpload+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Product product = new Product();
        product.setId(productForm.getId());
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        product.setImage(fileName);
        productService.createProduct(product);
        model.addAttribute("productForm",productForm);
        return"views";
    }
}
