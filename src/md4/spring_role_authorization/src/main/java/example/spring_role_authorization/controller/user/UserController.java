package example.spring_role_authorization.controller.user;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.Product;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ProductService productService;
    @Autowired
    private IAccountRepository accountRepository;

    @GetMapping("")
    public String index(Model model,
                        Principal principal,
                        @RequestParam(name = "page",defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> productList = productService.findAll(pageable);
        model.addAttribute("productList", productList);
        return "user/home";}

    @GetMapping("profile")
    public String profile(Model model,Principal principal){
        String username = principal.getName();
        Account account = accountRepository.findByUsername(username);
        model.addAttribute("account", account);
        return "user/profile";
    }

    @PostMapping("profile")
    public String profile(Model model, @ModelAttribute("account")Account account) {
        accountRepository.save(account);
        return "redirect:/user";
    }
}
