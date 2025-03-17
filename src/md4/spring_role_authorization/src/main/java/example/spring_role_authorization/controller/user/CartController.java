package example.spring_role_authorization.controller.user;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.CartItem;
import example.spring_role_authorization.model.Product;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.service.Impl.CartItemService;
import example.spring_role_authorization.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model, Principal principal) {
        String userName = principal.getName();
        Account account = accountRepository.findByUsername(userName);
        List<CartItem> cartItemList= cartItemService.selectAllProductInCartOfAccount(account.getId());
        long totalPrice = cartItemList.stream()
                .mapToLong(cart -> (long) (cart.getProduct().getPrice() * cart.getQuantity()))
                .sum();
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("totalProce",totalPrice);
        return "user/cart/cart-detail";
    }

    @GetMapping("/add")
    public String cart(Model model, Principal principal,
                       @RequestParam(name ="productId") int productId) {
        String userName = principal.getName();
        Account account = accountRepository.findByUsername(userName);
        Long accountId = account.getId();
        cartItemService.addProductInCartOfAccount(productId,accountId);

//        List<CartItem> cartItem = cartItemService.selectAllProductInCartOfAccount(productId,accountId);
//        model.addAttribute("cartItem",cartItem);
        return "redirect:/user";
    }

    @GetMapping("/increase")
    public String increase(Model model,@RequestParam(name ="productId") int productId,
                           Principal principal) {
        String username= principal.getName();
        Account account = accountRepository.findByUsername(username);
        Product product = productService.findById(productId);
        String error = product.getStock() ==0 ? "No Stock" : "";
        model.addAttribute("error",error);
        cartItemService.addProductInCartOfAccount(productId,account.getId());
        List<CartItem> cartItemList = cartItemService.selectAllProductInCartOfAccount(account.getId());
        model.addAttribute("cartItemList",cartItemList);
        long totalPrice = cartItemList.stream().mapToLong(cart -> (long) (cart.getProduct().getPrice()*cart.getQuantity())).sum();
        model.addAttribute("totalProce",totalPrice);
        return "user/cart/cart-detail";
    }

    @GetMapping("/reduce")
    public String reduceProduct(Model model,Principal prinicipal,
                               @RequestParam("productId") int productId ){
        String userName = prinicipal.getName();
        Account account = accountRepository.findByUsername(userName);
        Long accountId = account.getId();
        cartItemService.reduceProductInCartOfAccount(productId,accountId);

        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String deleteProduct(Principal principal,
                                @RequestParam(name ="productId") int productId,
                                Model model) {
        String username = principal.getName();
        Account account = accountRepository.findByUsername(username);
        Long accountId = account.getId();
        cartItemService.deleteProductIncartOfAccount(productId,accountId);
        List<CartItem> cartItemList = cartItemService.selectAllProductInCartOfAccount(accountId);
        model.addAttribute("cartItemList",cartItemList);
        return "user/cart/cart-detail";
    }
}
