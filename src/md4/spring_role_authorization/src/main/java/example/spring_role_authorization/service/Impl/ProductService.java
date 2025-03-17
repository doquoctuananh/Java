package example.spring_role_authorization.service.Impl;

import example.spring_role_authorization.model.Product;
import example.spring_role_authorization.repository.IProductRepository;
import example.spring_role_authorization.service.IProductService;
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
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchProductByNameAndColorAndPrice(Pageable pageable, String name, String color, double price) {
        return productRepository.searchProductByNameAndColorAndPrice(name,color,price,pageable);
    }
}
