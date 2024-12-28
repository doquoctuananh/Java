package example.service;

import example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImplProductService implements IProductService {
    private List<Product> products = new ArrayList<>();
    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> products() {
        return products;
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public void UpdateProduct(Product product) {

    }
}
