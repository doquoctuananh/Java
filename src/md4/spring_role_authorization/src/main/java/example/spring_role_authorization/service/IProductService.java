package example.spring_role_authorization.service;

import example.spring_role_authorization.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);


    Product findById(long id);
    Product save(Product product);
    void deleteById(long id);
    Page<Product> searchProductByNameAndColorAndPrice(Pageable pageable, String name, String color, double price);
}
