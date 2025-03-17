package example.spring_role_authorization.service.Impl;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.CartItem;
import example.spring_role_authorization.model.Product;
import example.spring_role_authorization.repository.CartItemRepository;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.repository.IProductRepository;
import example.spring_role_authorization.service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private IAccountRepository accountRepository;


    @Override
    public boolean checkProductInCartOfAccount(int productId, long accountId) {
        return cartItemRepository.exitsByProductAndAccount(productId, accountId);
    }

    @Override
    public List<CartItem> selectAllProductInCartOfAccount(long accountId) {
        List<CartItem> cartItem= new ArrayList<>();
        cartItem=cartItemRepository.selectALlProductOfAccount(accountId);
        return cartItem;
    }

    @Override
    public void addProductInCartOfAccount(int productId, long accountId) {
        if(checkProductInCartOfAccount(productId,accountId)) {
            List<CartItem> cartItem = selectAllProductInCartOfAccount(accountId);
            Product product = productService.findById(productId);
            if(product.getStock() >0){
                for (int i = 0; i < cartItem.size(); i++) {
                    if(cartItem.get(i).getProduct().getId() == productId){
                        cartItem.get(i).setQuantity(cartItem.get(i).getQuantity()+1);
                        break;
                    }
                }
                cartItemRepository.saveAll(cartItem);
                product.setStock(product.getStock()-1);
                productService.save(product);
            }
        }
        else{

            Product product = productService.findById(productId);
            if(product.getStock() >0){
                product.setStock(product.getStock() -1);
                productService.save(product);

                Account account = accountRepository.findById(accountId).get();
                CartItem cartItem = new CartItem(account,product,1);
                cartItemRepository.save(cartItem);
            }

        }
    }

    @Override
    public void reduceProductInCartOfAccount(int productId, long accountId) {
        List<CartItem> cartItemList = selectAllProductInCartOfAccount(accountId);

        CartItem cartItem = cartItemList.stream()
                .filter(cart -> cart.getProduct().getId() == productId && cart.getAccount().getId() == accountId)
                .collect(Collectors.toList()).get(0);

        Product product = productService.findById(productId);
        product.setStock(product.getStock() + 1);
        productService.save(product);
        if(cartItem.getQuantity() == 1){

            cartItemRepository.delete(cartItem);
        }
        else{
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            cartItemRepository.save(cartItem);
        }

    }

    @Override
    public void deleteProductIncartOfAccount(int productId, long accountId) {
        List<CartItem> cartItemList = cartItemRepository.selectALlProductOfAccount(accountId);


        Product product= productService.findById(productId);
        int quantity = cartItemList.stream()
                .filter(cart -> cart.getAccount().getId() == accountId && cart.getProduct().getId() ==productId)
                .collect(Collectors.toList()).get(0).getQuantity();

        product.setStock(product.getStock() + quantity);

        CartItem cartItem = cartItemList.stream()
                .filter(cart -> cart.getAccount().getId() == accountId && cart.getProduct().getId() == productId)
                .collect(Collectors.toList()).get(0);

        productService.save(product);
        cartItemRepository.deleteById(cartItem.getId());
    }
}
