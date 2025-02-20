package example.module4_examfinal.service;

import example.module4_examfinal.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAllProducts(Pageable pageable);
//    List<Product> findAllProducts();
    Product findProductById(int id);
    void saveProduct(Product product);

    List<Product> searchProducts(String name, Double price, Long typeId);
}
