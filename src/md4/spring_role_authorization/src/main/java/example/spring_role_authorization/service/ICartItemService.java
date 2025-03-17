package example.spring_role_authorization.service;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.CartItem;
import example.spring_role_authorization.model.Product;

import java.util.List;

public interface ICartItemService {
    boolean checkProductInCartOfAccount(int productId, long accountId);

    List<CartItem> selectAllProductInCartOfAccount(long accountId);

//    List<CartItem> selectAllProductInCartOfAccount(int productId, long accountId);
    void addProductInCartOfAccount(int productId, long accountId);

    void reduceProductInCartOfAccount(int productId, long accountId);

    void deleteProductIncartOfAccount(int productId, long accountId);
}
