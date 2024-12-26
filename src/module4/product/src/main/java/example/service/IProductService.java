package example.service;

import example.model.Product;

import java.util.List;

public interface IProductService {
    Product findProduct(int id);
    List<Product> showALlProduct();
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> searchProduct(String name);
}
