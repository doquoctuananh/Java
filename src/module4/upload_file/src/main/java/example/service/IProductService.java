package example.service;

import example.model.Product;

import java.util.List;

public interface IProductService {
    Product findById(int id);
    List<Product> products();
    void createProduct(Product product) ;
    void deleteProduct(int id) ;
    void UpdateProduct(Product product);

}
