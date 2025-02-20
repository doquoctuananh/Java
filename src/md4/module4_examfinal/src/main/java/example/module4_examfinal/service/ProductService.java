package example.module4_examfinal.service;

import example.module4_examfinal.model.Product;
import example.module4_examfinal.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }



    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
